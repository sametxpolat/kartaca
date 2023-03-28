package com.kartaca.softwaredeveloper.model;

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
@Table(name = "product", catalog = "kartaca")
public class Product {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      @Column(name = "id", unique = true, nullable = false)
      private Integer id;

      @Column(name = "name", length = 25, nullable = false)
      private String name;

      @Column(name = "description", length = 255, nullable = true)
      private String description;

      @Column(name = "date", updatable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP", nullable = false)
      private Date date;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "userIdFK", referencedColumnName = "id", nullable = false)
      private User user;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "catIdFK", referencedColumnName = "id", nullable = false)
      private Category category;

      public Product() {
      }

      public Product(Integer id) {
            this.id = id;
      }

      public Product(String name, String description, Date date, User user, Category category) {
            this.name = name;
            this.description = description;
            this.date = date;
            this.user = user;
            this.category = category;
      }

}
