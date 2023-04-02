package com.kartaca.softwaredeveloper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartaca.softwaredeveloper.model.Auction;
import com.kartaca.softwaredeveloper.service.AuctionService;

@RestController
@RequestMapping("/api/v1/auction")
public class AuctionController {

      @Autowired
      private AuctionService auctionService;

      @PostMapping("/set")
      public ResponseEntity<?> setAuction(@RequestBody Auction auction) {
            if(!auctionService.setAuction(auction)) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @GetMapping("/get")
      public ResponseEntity<List<Auction>> getAuction() {
            List<Auction> getedAuction = auctionService.getAuction();

            return ResponseEntity.status(HttpStatus.OK).body(getedAuction);
      }

}