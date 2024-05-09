package com.trim.scheduler.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    private final String defaultMessage;
    private final String errorKey;
    private final HttpStatus httpStatus;

    public ApiException(String message, String errorKey, HttpStatus httpStatus) {
        super(message);
        this.defaultMessage = message;
        this.errorKey = errorKey;
        this.httpStatus = httpStatus;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.defaultMessage = message;
        this.errorKey = ErrorConstants.UNKNOWN_ERROR;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}