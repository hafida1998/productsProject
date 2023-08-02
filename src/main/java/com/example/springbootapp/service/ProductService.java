package com.example.springbootapp.service;

import com.example.springbootapp.model.Product;
import com.example.springbootapp.repository.ProductRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Cacheable("products")
    public List<Product> getAllProducts() {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
    @Cacheable(value = "product",key = "#p0")

    public Optional<Product> getProduct(Long id) {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       return productRepository.findById(id);
    }
    @CacheEvict(value = "products",allEntries = true)

    public void addProduct(Product product) {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productRepository.save(product);
    }
    @CacheEvict(value = "products",allEntries = true)
    public void updateProduct(Long id, Product product) {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (productRepository.findById(id).get()!=null){
            productRepository.save(product);

        }


    }
    @CacheEvict(value = "products",allEntries = true)
    public void deleteProduct(Long id) {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productRepository.deleteById(id);
    }


}
