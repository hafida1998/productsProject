package com.example.springbootapp.controller;

import com.example.springbootapp.exeption.ProductNotFoundException;
import com.example.springbootapp.model.Product;
import com.example.springbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllTopProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{pId}")
    public Product getProduct(@PathVariable("pId") Long id) {
        return productService.getProduct(id).orElseThrow(()->new ProductNotFoundException(id));
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    @PutMapping("/product/{pId}")
    public void updateProduct(@PathVariable("pId") Long id,@RequestBody Product product){
       productService.updateProduct(id,product);
    }
    @DeleteMapping("/product/{pId}")
    public void deleteProduct(@PathVariable("pId")Long id) {
         productService.deleteProduct(id);
    }

}
