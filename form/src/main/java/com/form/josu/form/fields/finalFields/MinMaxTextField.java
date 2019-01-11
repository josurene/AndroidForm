package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.EditTextField;

public class MinMaxTextField extends EditTextField {

    private Integer min;
    private Integer max;

    public MinMaxTextField(View view,Integer min,Integer max) {
        super(view);
        this.min = min;
        this.max = max;
    }

    @Override
    public Boolean validate() {
        Boolean valid = (getText().length() >= min && getText().length() <= max);
        if(!valid){
            getTextView().setError("Invalid Length: "+min+"-"+max);
        }else {
            getTextView().setError(null);
        }
        return valid;
    }
}
