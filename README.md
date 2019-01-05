# AndroidForm
Custom Classes to make forms easier in android

Simple Text Example

Form formValidator = new Form();
("tag_of_the_field",field)
formValidator.addField("email",new RequiredTextField(findViewById(R.id.editText_email)));
formValidator.addField("password",new RequiredTextField(findViewById(R.id.editText_password)));

and then

if(formValidator.validate()){
//something
}

this will set the error on the editText

you can set or get the text
formValidator.getText("email")
formValidator.setText("email")

formValidator.getDouble("money")
formValidator.getBoolean("remember_me")

right now these are the types of views accepted, more will be added:

RequiredTextField
NotRequiredCheckedBoxField