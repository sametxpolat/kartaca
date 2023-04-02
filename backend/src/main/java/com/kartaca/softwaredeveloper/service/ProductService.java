package com.kartaca.softwaredeveloper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartaca.softwaredeveloper.model.Product;
import com.kartaca.softwaredeveloper.repository.ProductRepository;


@Service
public class ProductService {

      @Autowired
      private ProductRepository productRepository;

      // > adding product.
      public Boolean setProduct(Product product) {
            try {
                  productRepository.save(product);
                  return true;
            } catch (Exception e) {
                  throw e;
            }
            
      }
      
      // > getting user's products.
      public List<Product> findByUser_Id(Integer userId) {
            return productRepository.findByUser_Id(userId);
      }

}
