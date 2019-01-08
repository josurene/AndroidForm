package com.form.josu.formmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.form.josu.form.Form;
import com.form.josu.form.fields.finalFields.RequiredRadioGroupField;

public class MainActivity extends AppCompatActivity {

    Form form;

    TextView responseText;

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
        form.addField("radioGroup", new RequiredRadioGroupField(findViewById(R.id.radioGroup)));
    }

    private void setValidateButton(){
        findViewById(R.id.button_validate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean validation = form.validate();
                if(validation){
                    responseText.setText("Everything OK");
                }else {
                    responseText.setText("Something is missing");
                }
            }
        });
    }
}
