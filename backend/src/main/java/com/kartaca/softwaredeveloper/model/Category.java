package com.kartaca.softwaredeveloper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category", catalog = "kartaca@localhost")
public class Category {
      
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;

      @Column(name = "name", nullable = false)
      private String name;

      public Category() {
      }

      public Category(Integer id) {
            this.id = id;
      }

      public Category(String name) {
            this.name = name;
      }
      
}
