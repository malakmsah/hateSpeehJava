package com.project.convertedCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import com.runtimeconverter.jni.LoadLibrary;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@ServletComponentScan
@SpringBootApplication
public class Application {
    // Set this value to "true" to load the spring framework when a script is called in CLI mode
    // It will have no effect on the "web" command which needs spring boot to load the web server
    private static final boolean useSpringWithCLI = false;

    public static void main(String[] args) {
        LoadLibrary.loadLibrary();
        final boolean useWeb = args.length == 0;
        if (!useWeb && !useSpringWithCLI) {
            runCLI();
            System.exit(0);
        }
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(Application.class);
        // builder.properties("logging.pattern.console=");
        builder.bannerMode(Banner.Mode.CONSOLE);
        builder.web(useWeb);
        if (!useWeb) {
            System.out.println("\n\nLoading Spring in CLI Mode...");
        }
        builder.run(args);
    }

    private static void runCLI() {
        String scriptName = System.getProperty("runtimeConverterScriptName");
        String workingPath = System.getProperty("runtimeConverterWorkingPath");
        String[] args = new String[2];
        args[0] = scriptName;
        args[1] = workingPath;
        new com.project.convertedCode.main.ConvertedProjectRuntimeEnv().runCLI(args);
    }

    @Component
    public class ApplicationLoader implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            final boolean useWeb = args.length == 0;
            if (!useWeb) {
                runCLI();
            }
        }
    }

    // This "HiddenHttpMethodFilter" accesses the raw post contents and destroys the input stream
    // which is used by RuntimeEnv to get post variables
    @Bean
    public FilterRegistrationBean registration(HiddenHttpMethodFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
