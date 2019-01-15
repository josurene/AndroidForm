package com.form.josu.form.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import java.lang.reflect.Field;

public class EditTextAutoSaveDouble extends EditText {

    private static String TAG = "EditTextAuto";

    Class modelClass;
    Field field;
    Object object;

    public EditTextAutoSaveDouble(Context context) {
        super(context);
    }

    public EditTextAutoSaveDouble(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextAutoSaveDouble(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EditTextAutoSaveDouble(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EditTextAutoSaveDouble initialize(String fieldName, Class model, Object object){
        modelClass = model;
        this.object = object;
        try {
            field = modelClass.getField(fieldName);
        }catch (NoSuchFieldException e){
            Log.e(TAG,"Field does not exist",e);
        }
        return this;
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(field != null){
            try {
                field.set(object,Double.valueOf(text.toString()));
            }catch (IllegalAccessException e){
                Log.e(TAG,"Can't access field",e);
            }
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }
}
