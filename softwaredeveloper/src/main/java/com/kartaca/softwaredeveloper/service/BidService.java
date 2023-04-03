package com.kartaca.softwaredeveloper.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kartaca.softwaredeveloper.model.Bid;
// import com.kartaca.softwaredeveloper.model.LastBid;
import com.kartaca.softwaredeveloper.repository.BidRepository;
// import com.kartaca.softwaredeveloper.repository.LastBidRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class BidService {

      @Autowired
      private BidRepository bidRepository;

      // @Autowired
      // private LastBidRepository lastBidRepository;

      // > set bid for product.
      public Boolean setBid(Bid bid) {
            // LastBid lastBid = lastBidRepository.findByAuction_Id(bid.getAuction().getId());

            Bid lastBid = bidRepository.findByLastAuction(bid.getAuction().getId());
            BigDecimal bidPrice = bid.getPrice();

            if(lastBid != null && bidPrice.compareTo(lastBid.getPrice()) <= 0) {
                  throw new EntityExistsException("> err: not greater than the last bid!");
            }

            try {
                  bidRepository.save(bid);

                  // lastBid.setDate(setedBid.getDate());
                  // lastBid.setPrice(setedBid.getPrice());
                  // lastBid.setUser(setedBid.getUser());

                  // lastBidRepository.save(lastBid);

                  return true;
            } catch (Exception e) {
                  throw e;
            }
      }

}