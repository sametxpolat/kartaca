package com.kartaca.softwaredeveloper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartaca.softwaredeveloper.model.Auction;
import com.kartaca.softwaredeveloper.repository.AuctionRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class AuctionService {

      @Autowired
      private AuctionRepository auctionRepository;
      
      // > add products to auction.
      public Boolean setAuction(Auction auction) {
            try {
                  auctionRepository.save(auction);
                  return true;
            } catch (Exception e) {
                  throw e;
            }
      }

      // > get active products for auction.
      public List<Auction> getAuction() {
            List<Auction> getedAuction = auctionRepository.findByStatus(true);
            if(getedAuction == null) {
                  throw new EntityExistsException("> err: none auction");
            }

            return getedAuction;
      }
      
}