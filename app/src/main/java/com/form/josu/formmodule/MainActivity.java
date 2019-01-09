package com.form.josu.formmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.form.josu.form.Form;
import com.form.josu.form.fields.finalFields.RequiredRadioGroupField;
import com.form.josu.form.fields.finalFields.RequiredTextField;
import com.form.josu.form.views.EditTextAutoSave;
import com.form.josu.form.views.RadioGroupAutoSave;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Form form;

    TextView responseText;

    TestModel model = new TestModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = findViewById(R.id.textView_response);
        setForm();
        setValidateButton();
    }

    private void setForm(){
        form = new Form();

        List<Object> valuesForRadio = getValuesForRadioGroup();

        RadioGroupAutoSave radioGroupAutoSave = findViewById(R.id.radioGroup);
        form.addField("radioGroup", new RequiredRadioGroupField(radioGroupAutoSave.initialize("testRadioGroup",TestModel.class,model,valuesForRadio)));
        EditTextAutoSave editTextAutoSave = findViewById(R.id.editText);
        form.addField("testString", new RequiredTextField(editTextAutoSave.initialize("testString",TestModel.class,model)));
    }

    private void setValidateButton(){
        findViewById(R.id.button_validate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Test",model.toString());
                Boolean validation = form.validate();
                if(validation){
                    responseText.setText("Everything OK");
                }else {
                    responseText.setText("Something is missing");
                }
            }
        });
    }


    private List<Object> getValuesForRadioGroup(){
        List<Object> treeValues = new ArrayList<Object>();
        treeValues.add(1);
        treeValues.add(2);
        treeValues.add(3);
        return treeValues;
    }
}
