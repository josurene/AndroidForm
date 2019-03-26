package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.RadioGroupField;

public class RequiredRadioGroupField extends RadioGroupField {

    public RequiredRadioGroupField(View view) {
        super(view);
    }

    public RequiredRadioGroupField(View view,String tag) {
        super(view,tag);
    }

    @Override
    public Boolean validate() {
        Boolean validation = !(getRadioGroup().getCheckedRadioButtonId() == -1);
        if(!validation){
            getLastButton().setError("Required");
        }else {
            getLastButton().setError(null);
        }
        return validation;
    }

    @Override
    public Boolean validateWithoutSettingError() {
        return !(getRadioGroup().getCheckedRadioButtonId() == -1);
    }
}
