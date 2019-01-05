package com.form.josu.form.fields.baseFields;

import android.view.View;
import android.widget.EditText;

import com.form.josu.form.exceptions.WrongViewException;
import com.form.josu.form.fields.interfaces.Field;

public abstract class EditTextField implements Field {

    private EditText textView;

    public EditTextField(View view) {
        if(!(view instanceof EditText)){
            throw new WrongViewException(this.getClass().getName());
        }
        textView = (EditText)view;
    }

    @Override
    public void setView(View view) {
        if(view instanceof EditText){
            setTextView((EditText) view);
        }
    }

    public void setText(String text){
        textView.setText(text);
    }

    @Override
    public View getView() {
        return getTextView();
    }

    public EditText getTextView() {
        return textView;
    }

    public void setTextView(EditText mtextView){
        textView = mtextView;
    }

    public String getText() {
        return getTextView().getText().toString();
    }

    public Double getDouble() {
        return Double.valueOf(getText());
    }
}
