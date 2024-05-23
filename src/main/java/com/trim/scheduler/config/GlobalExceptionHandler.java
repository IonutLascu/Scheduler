package com.trim.scheduler.config;

import com.trim.scheduler.domain.api.ErrorResponse;
import com.trim.scheduler.utils.ApiException;
import com.trim.scheduler.utils.ErrorConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, WebRequest request) {

        return new ResponseEntity<>(ErrorResponse.builder()
            .statusCode(ex.getHttpStatus().value())
            .message(ex.getDefaultMessage())
            .error(ex.getErrorKey()).build(), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
            "Something went wrong",
            ErrorConstants.UNKNOWN_ERROR,
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}