package com.LogActivity.api.domain.exception;

public class CreateAccountValidationException extends RuntimeException{

    private final String errorCode;

    public CreateAccountValidationException(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
