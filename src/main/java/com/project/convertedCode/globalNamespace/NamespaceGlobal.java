package com.project.convertedCode.globalNamespace;

import com.runtimeconverter.runtime.functions.LazyInitZendFunction;

public class NamespaceGlobal {

    public static final LazyInitZendFunction date = new LazyInitZendFunction("date");;

    public static final LazyInitZendFunction stripos = new LazyInitZendFunction("stripos");;

    public static final LazyInitZendFunction implode = new LazyInitZendFunction("implode");;

    static {
        com.runtimeconverter.jni.LoadLibrary.loadLibrary();
    }
}
