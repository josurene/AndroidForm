package com.form.josu.form.fields.finalFields;

import android.view.View;
import android.widget.EditText;

import com.form.josu.form.fields.baseFields.EditTextField;

public class RequiredTextField extends EditTextField {

    public RequiredTextField(View view) {
        super(view);
    }


    @Override
    public Boolean validate(){
        Boolean valid = getText().length() > 0;
        if(!valid){
            getTextView().setError("Requerido");
        }
        return valid;
    }


}
