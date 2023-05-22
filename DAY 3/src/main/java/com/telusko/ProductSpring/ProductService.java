package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

   @Autowired
   ProductDB db;


    public void addProduct(Product p){
//        products.add(p);
          db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.findAll();
    }

    public void getProductByName(String name){
        List<Product> allProducts=db.findAll();

        allProducts.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(p-> System.out.println(p));

    }

    public  void getProductByText(String text){
        List<Product> allProducts=db.findAll();

        String str = text.toLowerCase();
        allProducts.stream()
                .filter(p->p.getName().toLowerCase().contains(str)
                        || p.getType().toLowerCase().contains(str)
                        || p.getPlace().toLowerCase().contains(str))
                .forEach(p-> System.out.println(p));

    }

    public void getProductByPlace(String place){
        List<Product> allProducts=db.findAll();
        List<Product> searchedPlaceProducts=new ArrayList<>();
        String searchPlace= place.toLowerCase();
        allProducts.stream()
                .filter(p->p.getPlace().toLowerCase().contains(searchPlace))
                .forEach(p-> System.out.println(p));


    }

    public void getProductsOutOfWarranty(){
        List<Product> allProducts=db.findAll();

        allProducts.stream()
                .filter(p->p.getWarranty()<2023)
                .forEach(p-> System.out.println(p));

    }


}