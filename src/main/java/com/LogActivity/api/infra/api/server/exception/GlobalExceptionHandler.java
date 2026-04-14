package com.LogActivity.api.infra.api.server.exception;

import com.LogActivity.api.domain.exception.CreateAccountValidationException;
import com.LogActivity.api.domain.exception.CreatePostActivityException;
import com.LogActivity.api.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CreateAccountValidationException.class)
    public ResponseEntity<ProblemDetail> createAccountExceptionHandler(CreateAccountValidationException ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("Account Creation has been Interrupted");
        problem.setProperty("errorType", ex.getErrorCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(CreatePostActivityException.class)
    public ResponseEntity<ProblemDetail> createPostActivityExceptionHandler(CreatePostActivityException ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("Post Creation has been Interrupted");
        problem.setProperty("errorType",ex.getErrorCode());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ProblemDetail> userNotFoundException(UserNotFoundException ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("User ID not Found");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }
}
