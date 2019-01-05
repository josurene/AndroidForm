package com.form.josu.form.fields.finalFields;

import android.view.View;
import android.widget.CheckBox;

import com.form.josu.form.fields.baseFields.CheckBoxField;

public class NotRequiredCheckBoxField extends CheckBoxField {

    public NotRequiredCheckBoxField(View view) {
        super(view);
    }

    @Override
    public Boolean validate() {
        return true;
    }
}
