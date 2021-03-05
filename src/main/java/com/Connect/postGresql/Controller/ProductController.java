package com.Connect.postGresql.Controller;


import com.Connect.postGresql.Model.Product;
import com.Connect.postGresql.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return (List<Product>) productService.getAll();
    }

    @PostMapping("/products")
    public List<Product> saveProduct(@RequestBody Product product){
        productService.save(product);
        return (List<Product>) productService.getAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id){
        Optional<Product> product = productService.findById(id);
        return product;
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "<p> Admin here </p>";
    }
}
