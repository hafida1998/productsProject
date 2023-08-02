package com.example.springbootapp.controller;

import com.example.springbootapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductWebController {
    @Autowired
    private ProductController productController;
    @GetMapping("/")
    public String getAllProducts (Model model){
        List<Product> productsList = productController.getAllTopProducts();
        model.addAttribute("products",productsList);
        return "List_Product";

    }
    @GetMapping("/newProduct")
    public String createNewProduct(Model model){
        Product product =new Product();
        model.addAttribute("product",product);
        return "New_Product";
    }
    @PostMapping("/save_new")
    public String saveNewProduct(@ModelAttribute("product") Product product){
        productController.addProduct(product);
        return "redirect:/";
    }
    @GetMapping("/update_product/{pId}")
    public String updateProduct(@PathVariable("pId")Long id , Model model){

        model.addAttribute("product",productController.getProduct(id));
        return "Update_Product";
    }
    @PostMapping("/save_update")
    public String saveUpdatedProduct(@ModelAttribute("product") Product product){
        productController.updateProduct(product.getId(),product);
        return "redirect:/";
    }
    @GetMapping("/delete_product/{pId}")
    public String deleteProduct(@PathVariable("pId")Long id , Model model){

        model.addAttribute("product",productController.getProduct(id));
        return "Delete_Product";
    }
    @PostMapping("/save_delete")
    public String saveDeletedProduct(@ModelAttribute("product") Product product){
        productController.deleteProduct(product.getId());
        return "redirect:/";
    }
}
