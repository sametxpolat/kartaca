package com.kartaca.softwaredeveloper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartaca.softwaredeveloper.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
      
      public List<Product> findByUser_Id(Integer userId); // > getting user's products.

}
