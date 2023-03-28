package com.kartaca.softwaredeveloper.model;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "auction", catalog = "kartaca")
public class Auction {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      @Column(name = "id", unique = true, nullable = false)
      private Integer id;

      @Column(name = "startPrice", precision = 10, scale = 2, nullable = false)
      private BigDecimal startPrice = BigDecimal.ZERO;

      @Column(name = "startDate", updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP", nullable = false)
      private Date startDate;

      @Column(name = "finishDate", nullable = true)
      private Date finishDate;

      @Column(name = "status", nullable = false)
      private Boolean status = false;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "prodIdFK", referencedColumnName = "id", nullable = false)
      private Product product;

      public Auction() {
      }

      public Auction(Integer id) {
            this.id = id;
      }

      public Auction(BigDecimal startPrice, Date startDate, Date finishDate, Boolean status, Product product) {
            this.startPrice = startPrice;
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.status = status;
            this.product = product;
      }

}
