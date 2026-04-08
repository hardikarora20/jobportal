package com.example.jobportal.exception;

import com.example.jobportal.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity <ErrorResponseDto> handleException(Exception exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setTimestamp(LocalDateTime.now());
        errorResponseDto.setStatus(500);
        errorResponseDto.setError(exception.getMessage());
        errorResponseDto.setPath(webRequest.getContextPath());
        errorResponseDto.setDetails(exception.getCause().toString());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    can handle each type of exception individually
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity <ErrorResponseDto> handleNullException(Exception exception, WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setTimestamp(LocalDateTime.now());
        errorResponseDto.setStatus(500);
        errorResponseDto.setError(exception.getMessage());
        errorResponseDto.setPath(webRequest.getContextPath());
        errorResponseDto.setDetails(exception.getCause().toString());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
