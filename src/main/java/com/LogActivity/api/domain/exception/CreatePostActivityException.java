package com.LogActivity.api.domain.exception;

public class CreatePostActivityException extends RuntimeException{

    private final String errorCode;

    public CreatePostActivityException(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
