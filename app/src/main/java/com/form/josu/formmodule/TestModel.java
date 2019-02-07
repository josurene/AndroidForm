package com.form.josu.formmodule;

import android.support.annotation.NonNull;

public class TestModel {
    Integer testRadioGroup;

    String testString;

    String testMinMax;

    Integer testInteger;

    String testAutoLoad = "testtest";

    @NonNull
    @Override
    public String toString() {
        return "radioGroup:"+testRadioGroup+" editText: "+testString;
    }
}
