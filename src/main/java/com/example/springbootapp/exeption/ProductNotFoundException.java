package com.example.springbootapp.exeption;

public class ProductNotFoundException extends RuntimeException{
    private static final Long serialVersionUID =1L;
    public ProductNotFoundException (Long id){
        super("the product with id = " + id + " not found");
    }
}
