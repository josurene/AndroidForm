package com.form.josu.form.fields.finalFields;

import android.view.View;
import android.widget.CheckBox;

import com.form.josu.form.fields.baseFields.CheckBoxField;

public class NotRequiredCheckBoxField extends CheckBoxField {

    public NotRequiredCheckBoxField(View view) {
        super(view);
    }

    public NotRequiredCheckBoxField(View view,String tag) {
        super(view,tag);
    }

    @Override
    public Boolean validate() {
        return true;
    }
}
