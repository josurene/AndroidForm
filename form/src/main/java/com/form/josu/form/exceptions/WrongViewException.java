package com.form.josu.form.exceptions;

public class WrongViewException extends RuntimeException{
    public WrongViewException(String origin){
        super("Error on: "+origin);
    }
}
