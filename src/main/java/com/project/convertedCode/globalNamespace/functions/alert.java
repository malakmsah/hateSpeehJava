package com.project.convertedCode.globalNamespace.functions;

import com.project.convertedCode.globalNamespace.functions.sendEmail;
import com.runtimeconverter.runtime.modules.standard.CRArrayF;
import com.runtimeconverter.runtime.functions.FunctionBaseRegular;
import com.project.convertedCode.globalNamespace.functions.printMessage;
import com.project.convertedCode.globalNamespace.NamespaceGlobal;
import com.runtimeconverter.runtime.classes.RuntimeClassBase;
import com.runtimeconverter.runtime.RuntimeEnv;
import com.runtimeconverter.runtime.ZVal;
import com.runtimeconverter.runtime.arrays.ZPair;

/*

 Converted with The Runtime Converter (runtimeconverter.com)

 /tmp/conversion_32414095399955819_721397749/input.txt

*/

public class alert extends FunctionBaseRegular {

    public static alert f = new alert();

    public Object call(RuntimeEnv env, Object... args) {
        Object foundWords = ZVal.assignParameter(args, 0, null);
        Object usedWords = null;
        Object author_id = null;
        printMessage.f.call(env, "Hate speech has been found");
        for (ZPair zpairResult2 : ZVal.getIterable(foundWords)) {
            author_id = ZVal.assign(zpairResult2.getKey());
            usedWords = ZVal.assign(zpairResult2.getValue());
            usedWords = CRArrayF.array_values.call(env, CRArrayF.array_unique.call(env, usedWords));
            printMessage.f.call(
                    env,
                    ZVal.toString(
                                    ZVal.toString(
                                                    ZVal.toString(
                                                                    "The author ["
                                                                            + ZVal.toString(
                                                                                    author_id))
                                                            + "] used the hate words [")
                                            + ZVal.toString(
                                                    NamespaceGlobal.implode.call(
                                                            env, ", ", usedWords)))
                            + "]");
            sendEmail.f.call(env);
        }

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
