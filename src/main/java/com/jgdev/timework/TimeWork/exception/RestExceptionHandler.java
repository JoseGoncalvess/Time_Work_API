package com.jgdev.timework.TimeWork.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionsdDetails> handlerValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        for (ObjectError error : allErrors) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        ExceptionsdDetails details = new ExceptionsdDetails(
                "Bad Request! Consult the Documentation",
                LocalDateTime.now(),
                ex.getCause().toString(),
                errors,
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<ExceptionsdDetails>(details, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionsdDetails> handlerBusinessException(BusinessException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getCause().toString(),ex.getMessage());
        ExceptionsdDetails details = new ExceptionsdDetails(
                "Bad Request! Consult the Documentation",
                LocalDateTime.now(),
                ex.getCause().toString(),
                errors,
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<ExceptionsdDetails>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionsdDetails> handlerRuntimeException(RuntimeException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getCause().toString(),ex.getMessage());
        ExceptionsdDetails details = new ExceptionsdDetails(
                "Bad Request! Consult the Documentation",
                LocalDateTime.now(),
                ex.getCause().toString(),
                errors,
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<ExceptionsdDetails>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionsdDetails> handlerRuntimeException(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getCause().toString(),ex.getMessage());
        ExceptionsdDetails details = new ExceptionsdDetails(
                "Bad Request! Consult Interno do Sitema",
                LocalDateTime.now(),
                ex.getCause().toString(),
                errors,
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<ExceptionsdDetails>(details, HttpStatus.BAD_REQUEST);
    }



}
