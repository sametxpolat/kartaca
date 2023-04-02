package com.kartaca.softwaredeveloper.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", catalog = "kartaca@localhost")
public class User implements Serializable {

      private static final Long serialVersionUID = 1L;

      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;

      @Transient
      private String uniqueId;

      @Column(name = "name", nullable = false)
      private String name;

      @Column(name = "surname", nullable = false)
      private String surname;

      @Column(name = "nickname", unique = true, nullable = false)
      private String nickname;

      @Column(name = "email", unique = true, nullable = false)
      private String email;

      @Column(name = "password", nullable = false)
      private String password;

      public User() {
      }

      public User(Integer id) {
            this.id = id;
      }

      public User(String name, String surname, String nickname, String email, String password) {
            this.name = name;
            this.surname = surname;
            this.nickname = nickname;
            this.email = email;
            this.password = password;
      }
      
}
