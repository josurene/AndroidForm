package com.form.josu.form.exceptions;

public class WrongFieldException extends RuntimeException{
    public WrongFieldException(String origin,String expected){
        super("Error on: "+origin+" Expected: "+expected);
    }
}
