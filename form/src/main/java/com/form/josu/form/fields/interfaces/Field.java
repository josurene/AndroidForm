package com.form.josu.form.fields.interfaces;

import android.view.View;

public abstract class Field {

    private String tag = "default";

    public abstract void setView(View view);

    public abstract View getView();

    public abstract Boolean validate();

    public abstract Boolean validateWithoutSettingError();

    public abstract void setError(String error);

    public String getTag(){
        return tag;
    }

    public void setTag(String tag){
        this.tag = tag;
    }
}
