package com.form.josu.form.validation.baseValidation;


import com.form.josu.form.fields.interfaces.Field;

public abstract class Validation {

    private String message = "";

    public abstract Boolean validate(Field field);


    public String getMessage() {
        return message;
    }

    public Validation setMessage(String message) {
        this.message = message;
        return this;
    }
}
