package com.kartaca.softwaredeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kartaca.softwaredeveloper.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
      
      public Boolean existsByEmail(String email); // > checking "email"

      public Boolean existsByNickname(String nickname); // > checking "nickname"

      public User findByEmail(String email);

}
