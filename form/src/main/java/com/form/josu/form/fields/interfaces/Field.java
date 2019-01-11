package com.form.josu.form.fields.interfaces;

import android.view.View;

public abstract interface Field {

    void setView(View view);

    View getView();

    Boolean validate();

    void setError(String error);
}
