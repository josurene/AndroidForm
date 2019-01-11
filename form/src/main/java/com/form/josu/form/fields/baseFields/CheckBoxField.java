package com.form.josu.form.fields.baseFields;

import android.view.View;
import android.widget.CheckBox;

import com.form.josu.form.exceptions.WrongViewException;
import com.form.josu.form.fields.interfaces.Field;

public abstract class CheckBoxField implements Field {

    private CheckBox checkBox;

    public CheckBoxField(View view) {
        if(!(view instanceof CheckBox)){
            throw new WrongViewException(this.getClass().getName());
        }
        checkBox = (CheckBox)view;
    }

    public Boolean getValue() {
        return getCheckBox().isChecked();
    }

    @Override
    public void setView(View view) {
        if(view instanceof CheckBox){
            setCheckBox((CheckBox)view);
        }
    }

    @Override
    public void setError(String error) {
        checkBox.setError(error);
    }

    @Override
    public View getView() {
        return getCheckBox();
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
