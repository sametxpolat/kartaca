package com.kartaca.softwaredeveloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartaca.softwaredeveloper.model.Bid;
import com.kartaca.softwaredeveloper.service.BidService;

@RestController
@RequestMapping("/api/v1/bid")
public class BidController {

      @Autowired
      private BidService bidService;

      @PostMapping("/set")
      public ResponseEntity<?> setBid(@RequestBody Bid bid) {
            if(!bidService.setBid(bid)) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            return ResponseEntity.status(HttpStatus.OK).build();
      }
      
}
