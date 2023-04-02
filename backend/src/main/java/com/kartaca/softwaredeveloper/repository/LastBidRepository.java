package com.kartaca.softwaredeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartaca.softwaredeveloper.model.LastBid;

@Repository
public interface LastBidRepository extends JpaRepository<LastBid, Integer> {
      
      public LastBid findByAuction_Id(Integer id);

}
