package com.example.springbootapp.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice

public class ProductNotFoundResponse {
    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFoundHandler(ProductNotFoundException productNotFoundException){
        return  productNotFoundException.getMessage();
    }
}
