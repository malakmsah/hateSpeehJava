package com.project.convertedCode.globalNamespace.functions;

import com.project.convertedCode.globalNamespace.functions.alert;
import com.runtimeconverter.runtime.functions.FunctionBaseRegular;
import com.project.convertedCode.globalNamespace.functions.printMessage;
import com.project.convertedCode.globalNamespace.NamespaceGlobal;
import com.runtimeconverter.runtime.classes.RuntimeClassBase;
import com.runtimeconverter.runtime.RuntimeEnv;
import com.project.convertedCode.globalNamespace.functions.getBlogPosts;
import com.project.convertedCode.globalNamespace.functions.getHateWordsList;
import com.runtimeconverter.runtime.ZVal;
import com.runtimeconverter.runtime.arrays.ZPair;

/*

 Converted with The Runtime Converter (runtimeconverter.com)

 /tmp/conversion_32414095399955819_721397749/input.txt

*/

public class main extends FunctionBaseRegular {

    public static main f = new main();

    public Object call(RuntimeEnv env, Object... args) {
        Object blogPosts = null;
        Object hateWord = null;
        Object hateWords = null;
        Object blogPost = ZVal.newArray();
        Object foundWords = ZVal.newArray();
        printMessage.f.call(env, "Execution started.");
        blogPosts = getBlogPosts.f.call(env);
        hateWords = getHateWordsList.f.call(env);
        foundWords = ZVal.newArray();
        for (ZPair zpairResult3 : ZVal.getIterable(blogPosts)) {
            blogPost = ZVal.assign(zpairResult3.getValue());
            for (ZPair zpairResult4 : ZVal.getIterable(hateWords)) {
                hateWord = ZVal.assign(zpairResult4.getValue());
                if (ZVal.toBool(!ZVal.isEmpty(ZVal.getElement(blogPost, "body")))
                        && ZVal.toBool(
                                ZVal.strictNotEqualityCheck(
                                        NamespaceGlobal.stripos.call(
                                                env, ZVal.getElement(blogPost, "body"), hateWord),
                                        "!==",
                                        false))) {
                    ZVal.setElementRecursive(
                            foundWords,
                            hateWord,
                            ZVal.getElement(blogPost, "author_id"),
                            ZVal.addToArray);
                }
            }
        }

        if (!ZVal.isEmpty(foundWords)) {
            alert.f.call(env, foundWords);

        } else {
            printMessage.f.call(env, "No hate speech has been found");
        }

        printMessage.f.call(env, "Execution done.");

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
