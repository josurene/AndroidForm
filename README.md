[![](https://jitpack.io/v/josurene/AndroidForm.svg)](https://jitpack.io/#josurene/AndroidForm)


# AndroidForm
Custom Classes to make forms easier in android

You can download this repo and run the example or add it on gradle.

allprojects {
    repositories {
        
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
	        implementation 'com.github.josurene:AndroidForm:abd789b9be'
}


Simple Text Example

Form formValidator = new Form();
("tag_of_the_field",field)
formValidator.addField("email",new RequiredTextField(findViewById(R.id.editText_email)));
formValidator.addField("password",new RequiredTextField(findViewById(R.id.editText_password)));
formValidator.addField("radioGroup", new RequiredRadioGroupField(findViewById(R.id.radioGroup)));

and then

if(formValidator.validate()){
//something
}

this will set the error on the editText

you can set or get the text ( NO LONGER NEEDED, you can use the autosave fields )
formValidator.getText("email")
formValidator.setText("email")

formValidator.getDouble("money")
formValidator.getBoolean("remember_me")

right now these are the types of views accepted, more will be added:

RequiredTextField
NotRequiredCheckedBoxField
RequiredRadioGroupField
RequiredIfVisibleTextField
MinMaxTextField

Autosave Fields
You use them like the previous fields
the difference is that you have to initialize them:
RadioGroupAutoSave radioGroupAutoSave = findViewById(R.id.radioGroup);
radioGroup:(name of the field in your object,the class of the model, the object of the model, an array of objects that are going to be the value for each radioButton)
radioGroupAutoSave.initialize("testRadioGroup",TestModel.class,model,valuesForRadio)

EditTextAutoSave editTextAutoSave = findViewById(R.id.editText);
editText:(name of the field in your object,the class of the model, the object of the model)
editTextAutoSave.initialize("testString",TestModel.class,model)

Here is the model for reference:
public class TestModel {
    Integer testRadioGroup;

    String testString;
}


On your xml:
<com.form.josu.form.views.EditTextAutoSave
...>
<com.form.josu.form.views.RadioGroupAutoSave
...>


Version 1.2 changes
RadioGroupAutoSave has a new listener
OnExtraCheckedChangeListener
it returns the value of the selection, usable in cases when you have to disable another field based on that value

Version 1.3
Added a new type of field that validates if the view is visible
RequiredIfVisibleTextField

Version 1.4
Can set an error to a field using the Form
formValidator.setError("field tag","error message");

Version 1.5
Added min max TestField
new MinMaxTextField(editTextAutoSave.initialize("testMinMax",TestModel.class,model),5,20)
