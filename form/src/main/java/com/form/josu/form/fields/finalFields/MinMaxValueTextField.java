package com.form.josu.form.fields.finalFields;

import android.view.View;

import com.form.josu.form.fields.baseFields.EditTextField;

public class MinMaxValueTextField extends EditTextField {

    private Integer min;
    private Integer max;
    private String message = null;

    public MinMaxValueTextField(View view, Integer min, Integer max) {
        super(view);
        this.min = min;
        this.max = max;
    }

    public MinMaxValueTextField(View view,String tag, Integer min, Integer max) {
        super(view,tag);
        this.min = min;
        this.max = max;
    }

    public MinMaxValueTextField(View view, Integer min, Integer max, String message) {
        super(view);
        this.min = min;
        this.max = max;
        this.message = message;
    }

    public MinMaxValueTextField(View view,String tag, Integer min, Integer max, String message) {
        super(view,tag);
        this.min = min;
        this.max = max;
        this.message = message;
    }

    @Override
    public Boolean validate() {
        Boolean valid = false;

        if(getText().length() >= 1 && getText().length() <= 9){
         Integer value = Integer.valueOf(getText());
         valid = (value >= min && value <= max);
        }
        if(!valid){
            if (message != null) {
                getTextView().setError(message);
            }else {
                getTextView().setError("Invalid Value: "+min+"-"+max);
            }
        }else {
            getTextView().setError(null);
        }
        return valid;
    }
}
