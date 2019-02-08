package com.form.josu.formmodule;

import android.support.annotation.NonNull;

public class TestModel {
    Integer testRadioGroup;

    String testString;

    String testMinMax;

    Integer testInteger;

    String testAutoLoad = "testtest";

    Integer testRadioGroupAutoLoad = 1;

    @NonNull
    @Override
    public String toString() {
        return "radioGroup:"+testRadioGroup+" editText: "+testString;
    }
}
