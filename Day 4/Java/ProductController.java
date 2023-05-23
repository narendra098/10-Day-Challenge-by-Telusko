package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("product/{name}")
    public Product getProduct(@PathVariable String name){
        return service.getProduct(name);
    }

    @PostMapping("/addproduct")
    public void addProduct(@RequestBody Product p){
        service.addProduct(p);
    }

    //lom-bock
    @GetMapping("/searchByText/{text}")
    public List<Product> getProductByText(@PathVariable String text){
     return service.getProductByText(text);
    }

    @GetMapping("/searchByPlace/{place}")
    public List<Product> getProductByPlace(@PathVariable String place){
        return service.getProductByPlace(place);
    }

    @GetMapping("/productsOutOfWarranty")
    public List<Product> getAllProductsOutOfWarranty(){
        return service.getProductsOutOfWarranty();
    }


}
