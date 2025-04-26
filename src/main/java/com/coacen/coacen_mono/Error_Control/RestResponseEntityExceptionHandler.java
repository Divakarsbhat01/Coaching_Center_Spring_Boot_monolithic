package com.coacen.coacen_mono.Error_Control;

import com.coacen.coacen_mono.Error_Control.Exceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(parentNotFoundException.class)
    public ResponseEntity<Error_Message> parentnotfoundexception(parentNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(studentNotFoundException.class)
    public ResponseEntity<Error_Message> studentnotfoundexception(studentNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(userNotFoundException.class)
    public ResponseEntity<Error_Message> usernotfoundexception(userNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(teacherNotFoundException.class)
    public ResponseEntity<Error_Message> teachernotfoundexception(teacherNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(courseNotFoundException.class)
    public ResponseEntity<Error_Message> coursenotfoundexception(courseNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(courseMaterialNotFoundException.class)
    public ResponseEntity<Error_Message> coursematerialnotfoundexception(courseMaterialNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @Override
    @ResponseStatus
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request)
    {
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            errors.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
