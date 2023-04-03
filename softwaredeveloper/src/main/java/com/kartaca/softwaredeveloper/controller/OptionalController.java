package com.kartaca.softwaredeveloper.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartaca.softwaredeveloper.model.Auction;
import com.kartaca.softwaredeveloper.model.Bid;
import com.kartaca.softwaredeveloper.model.Category;
import com.kartaca.softwaredeveloper.model.Product;
import com.kartaca.softwaredeveloper.model.User;
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
            Category cat01 = new Category("antique");
            Category cat02 = new Category("electronic");
            Category cat03 = new Category("other");

            categoryRepository.save(cat01);
            categoryRepository.save(cat02);
            categoryRepository.save(cat03);

            User user01 = new User("name01", "surname01", "nickname01", "email01@ex.com", "pass01");
            User user02 = new User("name02", "surname02", "nickname02", "email02@ex.com", "pass02");
            User user03 = new User("name03", "surname03", "nickname03", "email03@ex.com", "pass03");

            userService.setUser(user01);
            userService.setUser(user02);
            userService.setUser(user03);

            LocalDateTime ldt = LocalDateTime.now();

            Product prod01 = new Product("prod01", "desc01", ldt, user01, cat01);
            Product prod02 = new Product("prod02", "desc02", ldt, user01, cat02);
            Product prod03 = new Product("prod03", "desc03", ldt, user01, cat03);
            
            productService.setProduct(prod01);
            productService.setProduct(prod02);
            productService.setProduct(prod03);

            Auction auc01 = new Auction(BigDecimal.valueOf(500), ldt, ldt, true, prod01);

            auctionService.setAuction(auc01);

            Bid bid01 = new Bid(ldt, BigDecimal.valueOf(550), auc01, user02);
            Bid bid02 = new Bid(ldt, BigDecimal.valueOf(600), auc01, user03);
            Bid bid03 = new Bid(ldt, BigDecimal.valueOf(650), auc01, user02);
            Bid bid04 = new Bid(ldt, BigDecimal.valueOf(700), auc01, user03);

            bidService.setBid(bid01);
            bidService.setBid(bid02);
            bidService.setBid(bid03);
            bidService.setBid(bid04);

            return ResponseEntity.status(HttpStatus.OK).build();
      }
      
}
