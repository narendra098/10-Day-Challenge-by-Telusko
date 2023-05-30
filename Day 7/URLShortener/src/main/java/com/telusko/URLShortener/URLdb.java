package com.telusko.URLShortener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URLdb extends JpaRepository<URLGenerator,Integer> {
        
       
     

}
