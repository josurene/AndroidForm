package com.form.josu.form.fields.interfaces;

import android.view.View;

public abstract interface Field {

    public abstract void setView(View view);

    public abstract View getView();

    public abstract Boolean validate();
}
