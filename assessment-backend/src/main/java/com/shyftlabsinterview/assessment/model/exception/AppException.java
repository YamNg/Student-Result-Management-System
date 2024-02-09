package com.shyftlabsinterview.assessment.model.exception;

// Custom exception class, used for catching expected exception thrown by the app
public class AppException extends Exception{
    public AppException(String errorCode){
        super(errorCode);
    }
}
