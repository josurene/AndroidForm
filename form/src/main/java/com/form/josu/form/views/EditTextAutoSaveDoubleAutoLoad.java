package com.form.josu.form.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import java.lang.reflect.Field;

public class EditTextAutoSaveDoubleAutoLoad extends EditText {

    private static String TAG = "EditTextAuto";

    Class modelClass;
    Field field;
    Object object;

    public EditTextAutoSaveDoubleAutoLoad(Context context) {
        super(context);
    }

    public EditTextAutoSaveDoubleAutoLoad(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextAutoSaveDoubleAutoLoad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EditTextAutoSaveDoubleAutoLoad(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EditTextAutoSaveDoubleAutoLoad initialize(String fieldName, Class model, Object object){
        modelClass = model;
        this.object = object;
        try {
            field = modelClass.getField(fieldName);
            Double value = (Double)field.get(object);
            if (value != null){
                setText(""+value);
            }
        }catch (NoSuchFieldException e){
            Log.e(TAG,"Field does not exist",e);
        }catch (IllegalAccessException i){
            Log.e(TAG,"Field Not Public",i);
        }
        return this;
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(field != null  && text.length() >=1){
            try {
                field.set(object,Double.valueOf(text.toString()));
            }catch (IllegalAccessException e){
                Log.e(TAG,"Can't access field",e);
            }
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }
}
