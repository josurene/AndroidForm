package com.form.josu.form.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import java.lang.reflect.Field;

public class EditTextAutoSaveIntegerAutoLoad extends EditText {

    private static String TAG = "EditTextAuto";

    Class modelClass;
    Field field;
    Object object;

    public EditTextAutoSaveIntegerAutoLoad(Context context) {
        super(context);
    }

    public EditTextAutoSaveIntegerAutoLoad(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextAutoSaveIntegerAutoLoad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EditTextAutoSaveIntegerAutoLoad(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EditTextAutoSaveIntegerAutoLoad initialize(String fieldName, Class model, Object object){
        modelClass = model;
        this.object = object;
        try {
            field = modelClass.getField(fieldName);
            Integer value = (Integer)field.get(object);
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
        if(field != null && text.length() <= 9){
            try {
                field.set(object,Integer.valueOf(text.toString()));
            }catch (IllegalAccessException e){
                Log.e(TAG,"Can't access field",e);
            }
        }
    }
}
