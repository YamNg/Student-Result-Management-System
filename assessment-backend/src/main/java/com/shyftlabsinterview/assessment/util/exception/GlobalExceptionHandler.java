package com.shyftlabsinterview.assessment.util.exception;

import com.shyftlabsinterview.assessment.constant.ErrorCode;
import com.shyftlabsinterview.assessment.constant.ResponseStatus;
import com.shyftlabsinterview.assessment.model.exception.AppException;
import com.shyftlabsinterview.assessment.model.response.GenericResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;
import java.util.stream.Collectors;

// Global exception handler to manage the response return to frontend, in case of exception
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle expected error thrown by application itself
    @ExceptionHandler({AppException.class})
    public ResponseEntity<GenericResponseModel<Void>> handleAppException(AppException exception) {
        logger.error(exception.getMessage(), exception);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new GenericResponseModel<>(exception.getMessage()));
    }

    // Handle all validation errors
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<GenericResponseModel<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        logger.error(exception.getMessage(), exception);
        Set<String> errorCodes = exception.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new GenericResponseModel<>(String.join(",", errorCodes)));
    }


    // Catch all unhandled exception
    @ExceptionHandler({Exception.class})
    public ResponseEntity<GenericResponseModel<Void>> handleException(Exception exception) {
        logger.error(exception.getMessage(), exception);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponseModel<>(ErrorCode.UNEXPECTED_SYSTEM_ERROR));
    }
}
