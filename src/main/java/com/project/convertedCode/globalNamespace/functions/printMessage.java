package com.project.convertedCode.globalNamespace.functions;

import com.runtimeconverter.runtime.functions.FunctionBaseRegular;
import com.project.convertedCode.globalNamespace.NamespaceGlobal;
import com.runtimeconverter.runtime.classes.RuntimeClassBase;
import com.runtimeconverter.runtime.RuntimeEnv;
import com.runtimeconverter.runtime.ZVal;
import com.runtimeconverter.runtime.arrays.ZPair;

/*

 Converted with The Runtime Converter (runtimeconverter.com)

 /tmp/conversion_32414095399955819_721397749/input.txt

*/

public class printMessage extends FunctionBaseRegular {

    public static printMessage f = new printMessage();

    public Object call(RuntimeEnv env, Object... args) {
        Object message = ZVal.assignParameter(args, 0, null);
        env.echo(
                ZVal.toString(
                                ZVal.toString(
                                                ZVal.toString(
                                                                "["
                                                                        + ZVal.toString(
                                                                                NamespaceGlobal.date
                                                                                        .call(
                                                                                                env,
                                                                                                "Y-m-d H:i:s")))
                                                        + "] ")
                                        + ZVal.toString(message))
                        + ZVal.toString("\n"));

        return null;
    }

    public String ___getRuntimeFilename() {
        return "";
    }

    public String ___getRuntimeDirname() {
        return "";
    }

    public String ___getRuntimeNamespace() {
        return "";
    }
}
