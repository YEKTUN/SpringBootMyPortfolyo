package com.porffolyo.MyPortfolyo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            if (errorMap.containsKey(fieldName)) {

                errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), error.getDefaultMessage()));
            } else {
                errorMap.put(fieldName, addMapValue(new ArrayList<>(), error.getDefaultMessage()));
            }

           
        });
        return ResponseEntity.badRequest().body(createErrorResponse(new Date(), errorMap));


    }

    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    private ErrorResponse createErrorResponse(Date errorTime, Map<String, List<String>> errorMessage) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setId(UUID.randomUUID().toString());
        errorResponse.setErrorTime(errorTime);
        errorResponse.setErrorMessage(errorMessage);
        return errorResponse;
    }
}
