package com.kartaca.softwaredeveloper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartaca.softwaredeveloper.model.Auction;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

      public List<Auction> findByStatus(Boolean status); // > find active products for auction.
      
}
