package com.naveen.product.service.exception;

import com.naveen.product.service.exception.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedProductSerivceResponseEntityException
    extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> productNotFoundException(Exception exception, WebRequest request) {
        ExceptionMessage exceptionMessage = new ExceptionMessage
                    (new Date(), exception.getMessage(), request.getDescription(false) );
        return new ResponseEntity<Object> (exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final  ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
        ExceptionMessage exceptionMessage = new ExceptionMessage
                (new Date(), exception.getMessage(), request.getDescription(false) );
        return new ResponseEntity<Object> (exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
