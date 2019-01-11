package com.form.josu.form;

import com.form.josu.form.fields.baseFields.CheckBoxField;
import com.form.josu.form.fields.baseFields.EditTextField;
import com.form.josu.form.fields.interfaces.Field;

import java.util.HashMap;
import java.util.Map;

public class Form {

    private Map<String,Field> fields = new HashMap<>();

    public void addField(String key,Field field){
        fields.put(key,field);
    }

    public Boolean validate(){
        Boolean valid = true;
        for (Map.Entry<String,Field> e:fields.entrySet()) {
            if (!e.getValue().validate()){
                valid = false;
            }
        }
        System.out.println("valid: ");
        return valid;
    }

    public void setError(String key,String error){
        if(fields.containsKey(key)){
            fields.get(key).setError(error);
        }
    }

    public String getText(String key){
        if(fields.containsKey(key) && fields.get(key) instanceof EditTextField){
            return ((EditTextField)fields.get(key)).getText();
        }
        return "";
    }

    public void setText(String key, String value){
        if(fields.containsKey(key) && fields.get(key) instanceof EditTextField){
            ((EditTextField)fields.get(key)).setText(value);
        }
    }

    public Double getDouble(String key){
        if(fields.containsKey(key) && fields.get(key) instanceof EditTextField){
            return ((EditTextField)fields.get(key)).getDouble();
        }
        return 0d;
    }

    public Boolean getBoolean(String key){
        if(fields.containsKey(key) && fields.get(key) instanceof CheckBoxField){
            return ((CheckBoxField)fields.get(key)).getValue();
        }
        return false;
    }

}
