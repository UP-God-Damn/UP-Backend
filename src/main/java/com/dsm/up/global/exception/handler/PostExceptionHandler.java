package com.dsm.up.global.exception.handler;

import com.dsm.up.global.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;


@Slf4j
@RestControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<ErrorResponse> handlerDcsException (BaseException e) {
        log.error("[UP] : " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getErrorCode().getStatus(), e.getErrorCode().getMessage()), HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorResponse> handleNullPointException(NullPointerException e) {
        log.error("[NullPointerException] : " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(400, "Null Pointer Exception"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ErrorResponse> handleValidationException(ValidationException e) {
        log.error("[ValidationException] : " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(400, "Invalid value"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("[exception] : " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
