package com.kartaca.softwaredeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kartaca.softwaredeveloper.model.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {
      
      @Query("SELECT b FROM Bid b WHERE b.id = (SELECT MAX(c.id) FROM Bid c WHERE c.auction.id = ?1)")
      public Bid findByLastAuction(Integer id); // > find the final bind for product.

}
