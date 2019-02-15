package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.EditTextField;

public class MinMaxTextField extends EditTextField {

    private Integer min;
    private Integer max;
    private String message = null;

    public MinMaxTextField(View view,Integer min,Integer max) {
        super(view);
        this.min = min;
        this.max = max;
    }

    public MinMaxTextField(View view,String tag,Integer min,Integer max) {
        super(view,tag);
        this.min = min;
        this.max = max;
    }

    public MinMaxTextField(View view,Integer min,Integer max,String message) {
        super(view);
        this.min = min;
        this.max = max;
        this.message = message;
    }

    public MinMaxTextField(View view,String tag,Integer min,Integer max,String message) {
        super(view,tag);
        this.min = min;
        this.max = max;
        this.message = message;
    }

    @Override
    public Boolean validate() {
        Boolean valid = (getText().length() >= min && getText().length() <= max);
        if(!valid){
            if (message != null) {
                getTextView().setError(message);
            }else {
                getTextView().setError("Invalid Length: "+min+"-"+max);
            }
        }else {
            getTextView().setError(null);
        }
        return valid;
    }
}
