package com.form.josu.formmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.form.josu.form.Form;
import com.form.josu.form.fields.finalFields.MinMaxTextField;
import com.form.josu.form.fields.finalFields.RequiredRadioGroupField;
import com.form.josu.form.fields.finalFields.RequiredTextField;
import com.form.josu.form.fields.interfaces.Field;
import com.form.josu.form.views.EditTextAutoSave;
import com.form.josu.form.views.EditTextAutoSaveAutoLoad;
import com.form.josu.form.views.EditTextAutoSaveInteger;
import com.form.josu.form.views.RadioGroupAutoSave;
import com.form.josu.form.views.RadioGroupAutoSaveAutoLoad;

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
        form.addField("testRadioGroup", new RequiredRadioGroupField(radioGroupAutoSave.initialize("testRadioGroup",TestModel.class,model,valuesForRadio),"radio"));

        EditTextAutoSave editTextAutoSave = findViewById(R.id.editText);
        form.addField("testString", new RequiredTextField(editTextAutoSave.initialize("testString",TestModel.class,model),"edit"));

        EditTextAutoSaveInteger editTextAutoSaveInteger = findViewById(R.id.editText_int);
        form.addField("testInteger", new MinMaxTextField(editTextAutoSaveInteger.initialize("testInteger",TestModel.class,model),"edit",1,9));

        editTextAutoSave = findViewById(R.id.editText_min_mx);
        form.addField("testMinMax", new MinMaxTextField(editTextAutoSave.initialize("testMinMax",TestModel.class,model),"edit",5,20));

        EditTextAutoSaveAutoLoad editTextAutoSaveAutoLoad = findViewById(R.id.editText2);
        form.addField("testAutoLoad", new RequiredTextField(editTextAutoSaveAutoLoad.initialize("testAutoLoad",TestModel.class,model),"edit"));

        RadioGroupAutoSaveAutoLoad radioGroupAutoSaveAutoLoad = findViewById(R.id.radioGroup2);
        form.addField("testRadioGroupAutoLoad", new RequiredRadioGroupField(radioGroupAutoSaveAutoLoad.initialize("testRadioGroupAutoLoad",TestModel.class,model,valuesForRadio,1),"radio"));

        List<Field> radioFields = form.searchByTag("radio");
        List<Field> textFields = form.searchByTag("edit");
        Log.i("","");
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

        findViewById(R.id.button_validate_radio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Test",model.toString());
                Boolean validation = form.validateByTag("radio");
                if(validation){
                    responseText.setText("Everything OK in radio");
                }else {
                    responseText.setText("Something is missing in radio");
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
