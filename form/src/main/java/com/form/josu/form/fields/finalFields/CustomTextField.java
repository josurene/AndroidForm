package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.EditTextField;
import com.form.josu.form.validation.baseValidation.Validation;

import java.util.ArrayList;
import java.util.List;

public class CustomTextField extends EditTextField {


    private List<Validation> validations = new ArrayList<>();

    public CustomTextField(View view) {
        super(view);
    }

    public CustomTextField addValidation(Validation v){
        validations.add(v);
        return this;
    }

    @Override
    public Boolean validate(){
        for (Validation v:validations) {
            if(!v.validate(this)){
                getTextView().setError(v.getMessage());
                return false;
            }
        }
        return true;
    }
}
