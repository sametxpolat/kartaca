package com.kartaca.softwaredeveloper.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bid", catalog = "kartaca@localhost")
public class Bid {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;

      @Column(name = "date", updatable = false, nullable = false)
      private LocalDateTime date = LocalDateTime.now();

      @Column(name = "price", precision = 10, scale = 2, nullable = false)
      private BigDecimal price;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "auction_id", referencedColumnName = "id", nullable = false)
      private Auction auction;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
      private User user;
      
      public Bid() {
      }

      public Bid(Integer id) {
            this.id = id;
      }

      public Bid(LocalDateTime date, BigDecimal price, Auction auction, User user) {
            this.date = date;
            this.price = price;
            this.auction = auction;
            this.user = user;
      }
}