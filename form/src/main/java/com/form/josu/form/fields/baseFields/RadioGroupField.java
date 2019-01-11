package com.form.josu.form.fields.baseFields;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.form.josu.form.exceptions.WrongViewException;
import com.form.josu.form.fields.interfaces.Field;


public abstract class RadioGroupField implements Field {

    private RadioGroup radioGroup;
    private RadioButton lastButton;

    public RadioGroupField(View view) {
        if(!(view instanceof RadioGroup)){
            throw new WrongViewException(this.getClass().getName());
        }
        radioGroup = (RadioGroup)view;
        lastButton = (RadioButton) radioGroup.getChildAt(radioGroup.getChildCount() - 1);
    }

    @Override
    public void setView(View view) {
        if (view instanceof RadioGroup){
            radioGroup = (RadioGroup)view;
        }
    }

    @Override
    public void setError(String error) {
        lastButton.setError(error);
    }

    @Override
    public View getView() {
        return radioGroup;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public RadioButton getLastButton() {
        return lastButton;
    }
}
