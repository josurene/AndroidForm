package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.EditTextField;

public class RequiredIfVisibleTextField extends EditTextField {

    public RequiredIfVisibleTextField(View view) {
        super(view);
    }

    public RequiredIfVisibleTextField(View view,String tag) {
        super(view);
    }


    @Override
    public Boolean validate(){
        Boolean valid = (getText().length() > 0) || !(getView().getVisibility() == View.VISIBLE);
        if(!valid){
            getTextView().setError("Required");
        }else {
            getTextView().setError(null);
        }
        return valid;
    }

    @Override
    public Boolean validateWithoutSettingError() {
        return (getText().length() > 0) || !(getView().getVisibility() == View.VISIBLE);
    }


}
