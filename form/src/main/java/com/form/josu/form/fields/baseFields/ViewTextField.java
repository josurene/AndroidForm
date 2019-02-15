package com.form.josu.form.fields.baseFields;

import android.view.View;
import android.widget.TextView;

import com.form.josu.form.exceptions.WrongViewException;
import com.form.josu.form.fields.interfaces.Field;

public abstract class ViewTextField extends Field {

    private TextView textView;

    public ViewTextField(View view) {
        if(!(view instanceof TextView)){
            throw new WrongViewException(this.getClass().getName());
        }
        textView = (TextView)view;
    }

    public ViewTextField(View view,String tag) {
        if(!(view instanceof TextView)){
            throw new WrongViewException(this.getClass().getName());
        }
        textView = (TextView)view;
        setTag(tag);
    }

    @Override
    public void setView(View view) {
        if(view instanceof TextView){
            setTextView((TextView) view);
        }
    }

    public void setText(String text){
        textView.setText(text);
    }

    @Override
    public void setError(String error) {
        textView.setError(error);
    }

    @Override
    public View getView() {
        return getTextView();
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView mtextView){
        textView = mtextView;
    }

    public String getText() {
        return getTextView().getText().toString();
    }

    public Double getDouble() {
        return Double.valueOf(getText());
    }
}
