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
@Table(name = "user", catalog = "kartaca")
public class User {

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      @Column(name = "id", unique = true, nullable = false)
      private Integer id;

      @Column(name = "name", length = 25, nullable = false)
      private String name;

      @Column(name = "surname", length = 25, nullable = false)
      private String surname;

      @Column(name = "nickname", unique = true, length = 25, nullable = false)
      private String nickname;

      @Column(name = "email", unique = true, length = 50, nullable = false)
      private String email;

      public User() {
      }

      public User(Integer id) {
            this.id = id;
      }

      public User(String name, String surname, String nickname, String email) {
            this.name = name;
            this.surname = surname;
            this.nickname = nickname;
            this.email = email;
      }
      
}
