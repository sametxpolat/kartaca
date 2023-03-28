package com.kartaca.softwaredeveloper.model;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.Where;

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
@Table(name = "lastbid", catalog = "kartaca")
@Where(clause = "id in (select max(id) from bid group by aucIdFK)")
public class LastBid {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      @Column(name = "id", unique = true, nullable = false)
      private Integer id;

      @Column(name = "date", updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP", nullable = false)
      private Date date;

      @Column(name = "price", precision = 10, scale = 2, nullable = false)
      private BigDecimal price;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "aucIdFK", referencedColumnName = "id", nullable = false)
      private Auction auction;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "userIdFK", referencedColumnName = "id", nullable = false)
      private User user;
      
      public LastBid() {
      }

      public LastBid(Integer id) {
            this.id = id;
      }

      public LastBid(Date date, BigDecimal price, Auction auction, User user) {
            this.date = date;
            this.price = price;
            this.auction = auction;
            this.user = user;
      }
}
