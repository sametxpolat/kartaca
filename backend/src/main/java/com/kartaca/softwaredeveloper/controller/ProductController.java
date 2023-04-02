package com.kartaca.softwaredeveloper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartaca.softwaredeveloper.model.Product;
import com.kartaca.softwaredeveloper.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

      @Autowired
      private ProductService productService;
      
      @PostMapping("/set")
      public ResponseEntity<?> setProduct(@RequestBody Product product) {
            if(!productService.setProduct(product)) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @GetMapping("/user/{userId}")
      public ResponseEntity<List<Product>> getUserProduct(@PathVariable Integer userId) {
            List<Product> getedUserProduct = productService.findByUser_Id(userId);

            if(getedUserProduct == null) {
                  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.status(HttpStatus.OK).body(getedUserProduct);
      }

}