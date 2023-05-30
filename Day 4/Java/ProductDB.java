package com.telusko.ProductSpringWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

  Product findByName(String name);

  @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:text% OR Lower(p.type) LIKE %:text% OR LOWER(p.place) LIKE %:text% OR CAST(p.warranty AS string) LIKE %:text%")
  List<Product> findByText(@Param("text") String text);

  @Query("SELECT p FROM Product p WHERE Lower(p.place) Like %:place%")
  List<Product> findByPlace(@Param("place") String place);

  @Query("SELECT p FROM Product p WHERE p.warranty < 2024")
  List<Product> findProductsByWarranty();


}

