package com.form.josu.form.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RadioGroupAutoSave extends RadioGroup {

    private static String TAG = "RadioGroupAuto";

    OnExtraCheckedChangeListener onExtraCheckedChangeListener = null;

    Class modelClass;
    Field field;
    Object object;
    List<Object> values;
    List<View> childList;

    public RadioGroupAutoSave(Context context) {
        super(context);
    }

    public RadioGroupAutoSave(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadioGroupAutoSave initialize(String fieldName,Class model,Object object,List<Object> values){
        modelClass = model;
        this.object = object;
        this.values = values;
        try {
            field = modelClass.getField(fieldName);
        }catch (NoSuchFieldException e){
            Log.e(TAG,"Field does not exist",e);
        }
        fillChildList();
        setListener();
        return this;
    }

    private void fillChildList(){
        childList = new ArrayList<>();
        int size = getChildCount();
        for (int i=0;i<size;i++){
            childList.add(getChildAt(i));
        }
    }

    private void setListener(){
        this.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

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
