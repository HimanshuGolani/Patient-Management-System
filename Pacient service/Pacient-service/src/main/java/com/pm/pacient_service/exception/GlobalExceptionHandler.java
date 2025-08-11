package com.pm.pacient_service.exception;

import com.pm.pacient_service.dto.response.ErrorResponseDto;
import com.pm.pacient_service.exception.custom.EmailAlreadyExistsException;
import com.pm.pacient_service.exception.custom.PatientNotFoundException;
import com.pm.pacient_service.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handelValidationException(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>();
        log.error(e.getMessage());
        e.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(),error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handelEmailAlreadyException(EmailAlreadyExistsException ex){
        Map<String,String> error = new HashMap<>();
        log.error(ex.getMessage());
        error.put("message",ex.getMessage());
        return ResponseEntity.badRequest().body(
                error
        );
    }

    @ExceptionHandler(InternalError.class)
    public ResponseEntity<Map<String,String>> handelInternalSererError( Exception e ){
        Map<String,String> error = new HashMap<>();
        log.error(e.getMessage());
        error.put("message",e.getMessage());
        return ResponseEntity.internalServerError().body(
                error
        );
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handelPatientNotFoundException(PatientNotFoundException e){
        return new ResponseEntity<>(new ErrorResponseDto(e.getMessage()),HttpStatus.NOT_FOUND);
    }


}
