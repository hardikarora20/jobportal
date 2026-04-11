package com.example.jobportal.exception;

import com.example.jobportal.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <Map<String, String>> handleEachValidation(MethodArgumentNotValidException exception){
        Map <String, String> errorMap = new HashMap<>();
//        to specifically get only field errors
        List<FieldError> errorList = exception.getBindingResult().getFieldErrors();
        System.out.println(errorList);
        errorList.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        System.out.println(errorMap);
        return ResponseEntity.badRequest().body(errorMap);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(ConstraintViolationException exception) {
        Map<String, String> errorMap = new HashMap<>();

        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            errorMap.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return ResponseEntity.badRequest().body(errorMap);
    }

}
