package com.carRentalSystem.Exception;

import com.carRentalSystem.Payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHadler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponse> ResourceNotFoundExpHandler(ResourceNotFound resourceNotFound){
        ErrorResponse errorResponse = new ErrorResponse(resourceNotFound.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now() );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> Validation(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> response= new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName,message);
        });
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidLicenseException.class)
    public ResponseEntity<ErrorResponse> InvalidException(InvalidLicenseException inv){
        ErrorResponse errorResponse = new ErrorResponse(inv.getMessage(),HttpStatus.BAD_REQUEST,LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
