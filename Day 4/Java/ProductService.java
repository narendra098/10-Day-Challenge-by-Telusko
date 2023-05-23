package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

   @Autowired
   ProductDB db;


    public void addProduct(Product p){

          db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.findAll();
    }

    public Product getProduct(String name){
       return db.findByName(name);

    }

    public List<Product> getProductByText(String text){
       return db.findByText(text.toLowerCase());

    }

    public List<Product> getProductByPlace(String place){
      return db.findByPlace(place.toLowerCase());

    }

    public List<Product> getProductsOutOfWarranty(){
      return db.findProductsByWarranty();
    }


}