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
@Table(name = "auction", catalog = "kartaca@localhost")
public class Auction {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;

      @Column(precision = 10, scale = 2, nullable = false)
      private BigDecimal startPrice;

      @Column(updatable = false, nullable = false)
      private LocalDateTime startDate = LocalDateTime.now();

      @Column(nullable = true)
      private LocalDateTime finishDate;

      @Column(name = "status", nullable = false)
      private Boolean status = true;

      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
      private Product product;

      public Auction() {
      }

      public Auction(Integer id) {
            this.id = id;
      }

      public Auction(BigDecimal startPrice, LocalDateTime startDate, LocalDateTime finishDate, Boolean status, Product product) {
            this.startPrice = startPrice;
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.status = status;
            this.product = product;
      }

}