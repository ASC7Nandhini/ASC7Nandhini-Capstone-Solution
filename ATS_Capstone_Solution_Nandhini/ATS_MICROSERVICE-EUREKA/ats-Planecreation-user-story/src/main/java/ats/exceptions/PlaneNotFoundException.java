package ats.exceptions;

public class PlaneNotFoundException extends RuntimeException{
    public PlaneNotFoundException(String message){
        super(message);
    }
}
