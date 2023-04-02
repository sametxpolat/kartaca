package com.kartaca.softwaredeveloper.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "product", catalog = "kartaca@localhost")
public class Product {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;

      @Column(name = "name", nullable = false)
      private String name;

      @Column(name = "description", nullable = true)
      private String description;

      @Column(name = "date", updatable = false, nullable = false)
      private LocalDateTime date = LocalDateTime.now();

      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
      @JsonIgnoreProperties({"name", "surname", "email", "password"})
      private User user;

      @ManyToOne(fetch = FetchType.EAGER)
      @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
      private Category category;

      public Product() {
      }

      public Product(Integer id) {
            this.id = id;
      }

      public Product(String name, String description, LocalDateTime date, User user, Category category) {
            this.name = name;
            this.description = description;
            this.date = date;
            this.user = user;
            this.category = category;
      }

}
