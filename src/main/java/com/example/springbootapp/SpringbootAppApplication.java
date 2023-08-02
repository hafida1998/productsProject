package com.example.springbootapp;

import com.example.springbootapp.model.Product;
import com.example.springbootapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("television","electronics"));
        productRepository.save(new Product("air conditioner","electronics"));
        productRepository.save(new Product("scissors","stationary"));
        productRepository.save(new Product("pen","stationary"));

    }
}
