package com.form.josu.form.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RadioGroupAutoSaveAutoLoadBoolean extends RadioGroup {

    private static String TAG = "RadioGroupAuto";

    OnExtraCheckedChangeListener onExtraCheckedChangeListener = null;

    private Class modelClass;
    private Field field;
    private Object object;
    private List<Object> values;
    private List<View> childList;
    private RadioButton lastButton;

    public RadioGroupAutoSaveAutoLoadBoolean(Context context) {
        super(context);
    }

    public RadioGroupAutoSaveAutoLoadBoolean(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadioGroupAutoSaveAutoLoadBoolean initialize(String fieldName, Class model, Object object, List<Object> values, Boolean offset){
        modelClass = model;
        this.object = object;
        this.values = values;
        fillChildList();
        setListener();
        try {
            field = modelClass.getField(fieldName);
            Boolean value = (Boolean) field.get(object);
            if (value != null){
                if(offset){
                    value = !value;
                }
                RadioButton button;
                if (value){
                    button = (RadioButton) childList.get(0);
                }else {
                    button = (RadioButton) childList.get(1);
                }
                if (button != null){
                    button.setChecked(true);
                }
            }
        }catch (NoSuchFieldException e){
            Log.e(TAG,"Field does not exist",e);
        }catch (IllegalAccessException i){
            Log.e(TAG,"Field Not Public",i);
        }
        return this;
    }

    private void fillChildList(){
        childList = new ArrayList<>();
        int size = getChildCount();
        for (int i=0;i<size;i++){
            childList.add(getChildAt(i));
        }
        lastButton = (RadioButton) this.getChildAt(this.getChildCount() - 1);
    }

    private void setListener(){
        this.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                lastButton.setError(null);

                if(field != null){
                    Integer index = -1;
                    for (int i=0;i<childList.size();i++) {
                        if(childList.get(i).getId() == checkedId){
                            index = i;
                            break;
                        }
                    }

                    if(index != -1){
                        try {
                            Object value = values.get(index);
                            field.set(object,value);
                            if(onExtraCheckedChangeListener != null){
                                onExtraCheckedChangeListener.onCheckedChanged(value);
                            }
                        }catch (IllegalAccessException e){
                            Log.e(TAG,"Can't access field",e);
                        }
                    }
                }


            }
        });

    }

    public interface OnExtraCheckedChangeListener{
        void onCheckedChanged(Object value);
    };

    public void setOnExtraCheckedChangeListener(OnExtraCheckedChangeListener onExtraCheckedChangeListener) {
        this.onExtraCheckedChangeListener = onExtraCheckedChangeListener;
    }

}
