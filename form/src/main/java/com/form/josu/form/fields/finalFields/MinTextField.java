package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.EditTextField;

public class MinTextField extends EditTextField {

    private Integer min;
    private String message = null;

    public MinTextField(View view, Integer min) {
        super(view);
        this.min = min;
    }

    public MinTextField(View view, String tag, Integer min) {
        super(view,tag);
        this.min = min;
    }

    public MinTextField(View view, Integer min, String message) {
        super(view);
        this.min = min;
        this.message = message;
    }

    public MinTextField(View view, String tag, Integer min, String message) {
        super(view,tag);
        this.min = min;
        this.message = message;
    }

    @Override
    public Boolean validate() {
        Boolean valid = getText().length() >= min;
        if(!valid){
            if (message != null) {
                getTextView().setError(message);
            }else {
                getTextView().setError("Min Length: "+min);
            }
        }else {
            getTextView().setError(null);
        }
        return valid;
    }
}
