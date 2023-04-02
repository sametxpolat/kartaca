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

/*
 * 
 * Bu tablo, ürüne gelen son teklifi tutmak için oluşturulmuştur. Açık arttırma sisteminin yoğun bir trafiği olacağı düşünülünce teklif tablosundan o ürüne ait son teklifi bulmak performans kaybına yol açacaktır. Bu yüzden son teklif ayrı bir tabloda tutulmak istenmiştir.
 * 
 */

@Getter
@Setter
@Entity
@Table(name = "lastbid", catalog = "kartaca@localhost")
public class LastBid {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;

      @Column(name = "date", updatable = false, nullable = false)
      private LocalDateTime date = LocalDateTime.now();

      @Column(name = "price", precision = 10, scale = 2, nullable = false)
      private BigDecimal price;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "auction_id", unique = true, referencedColumnName = "id", nullable = false)
      private Auction auction;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
      private User user;
      
      public LastBid() {
      }

      public LastBid(Integer id) {
            this.id = id;
      }

      public LastBid(LocalDateTime date, BigDecimal price, Auction auction, User user) {
            this.date = date;
            this.price = price;
            this.auction = auction;
            this.user = user;
      }
}