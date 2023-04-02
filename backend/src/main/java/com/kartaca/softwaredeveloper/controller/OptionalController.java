package com.kartaca.softwaredeveloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartaca.softwaredeveloper.repository.CategoryRepository;
import com.kartaca.softwaredeveloper.service.AuctionService;
import com.kartaca.softwaredeveloper.service.BidService;
import com.kartaca.softwaredeveloper.service.ProductService;
import com.kartaca.softwaredeveloper.service.UserService;

@RestController
@RequestMapping("/optional")
public class OptionalController {

      @Autowired
      private UserService userService;

      @Autowired
      private ProductService productService;

      @Autowired
      private CategoryRepository categoryRepository;

      @Autowired
      private AuctionService auctionService;

      @Autowired
      private BidService bidService;

      @PostMapping
      public ResponseEntity<?> autoGenerate() {
            return null;
      }
      
}
