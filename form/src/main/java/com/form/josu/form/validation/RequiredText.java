package com.form.josu.form.validation;


import com.form.josu.form.exceptions.WrongFieldException;
import com.form.josu.form.fields.baseFields.EditTextField;
import com.form.josu.form.fields.interfaces.Field;
import com.form.josu.form.validation.baseValidation.Validation;

public class RequiredText extends Validation {

    public RequiredText(){
        setMessage("Required");
    }

    @Override
    public Boolean validate(Field field) {
        if(!(field instanceof EditTextField)){
            throw new WrongFieldException(getClass().getName(),EditTextField.class.getName());
        }
        return ((EditTextField)field).getTextView().getText().toString().length() > 0;
    }
}
