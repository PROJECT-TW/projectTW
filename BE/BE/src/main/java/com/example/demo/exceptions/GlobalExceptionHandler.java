package com.example.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDto> handleConflict(CustomException exception){

        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                exception.getHttpStatus().value(),
                exception.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.ok().body(responseDto);
    }

}