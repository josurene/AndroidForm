package com.form.josu.formmodule;

import android.support.annotation.NonNull;

public class TestModel {
    Integer testRadioGroup;

    String testString;

    @NonNull
    @Override
    public String toString() {
        return "radioGroup:"+testRadioGroup+" editText: "+testString;
    }
}
