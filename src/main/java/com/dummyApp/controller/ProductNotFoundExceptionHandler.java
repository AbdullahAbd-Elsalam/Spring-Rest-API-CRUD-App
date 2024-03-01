package com.dummyApp.controller;

import com.dummyApp.Exception.EmptyException;
import com.dummyApp.Exception.ProductNotFoundError;
import com.dummyApp.Exception.TypeNotMatchException;
import com.dummyApp.Exception.response.ProductResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundExceptionHandler {

    // handle your exception of product not found
    @ExceptionHandler
    public ResponseEntity<ProductResponseError> ProductError(ProductNotFoundError exception){

        ProductResponseError responseError=new ProductResponseError();
        responseError.setCode(HttpStatus.NOT_FOUND.value());
        responseError.setMessege(exception.getMessage());
        responseError.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);

    }

    // test another exception
    @ExceptionHandler
    public ResponseEntity<ProductResponseError> empityError(EmptyException exception){

        ProductResponseError responseError=new ProductResponseError();
        responseError.setCode(HttpStatus.BAD_REQUEST.value());
        responseError.setMessege(exception.getMessage());
        responseError.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);

    }

    // test another exception
    @ExceptionHandler
    public ResponseEntity<ProductResponseError> TypeError(TypeNotMatchException exception){

        ProductResponseError responseError=new ProductResponseError();
        responseError.setCode(HttpStatus.BAD_REQUEST.value());
        responseError.setMessege(exception.getMessage());
        responseError.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);

    }

}
