package com.kartaca.softwaredeveloper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kartaca.softwaredeveloper.model.User;
import com.kartaca.softwaredeveloper.repository.UserRepository;
import com.kartaca.softwaredeveloper.service.middleware.SecurityService;

import jakarta.persistence.EntityExistsException;

@Service
public class UserService {
      
      @Autowired
      private UserRepository userRepository;

      @Autowired
      private SecurityService securityService;

      // > creating user.
      public Boolean setUser(User user) {
            if(userRepository.existsByEmail(user.getEmail())) {
                  throw new EntityExistsException("> err: email taken!");
            }

            if(userRepository.existsByNickname(user.getNickname())) {
                  throw new EntityExistsException("> err: nickname taken!");
            }

            try {
                  user.setPassword(securityService.encoder(user.getPassword()));
                  userRepository.save(user);
                  return true;
            } catch (Exception e) {
                  throw e;
            }
      }

      // > login user and cache with redis.
      @Cacheable(value = "user", key = "#uniqueId")
      public User getUser(String email, String password, String uniqueId) {
            User existsUser = userRepository.findByEmail(email);

            if(existsUser == null) {
                  throw new EntityExistsException("> err: user not found!");
            }
            if(!securityService.decoder(password, existsUser.getPassword())) {
                  throw new EntityExistsException("> err: email or password incorrect!");
            }

            existsUser.setUniqueId(uniqueId);
            existsUser.setPassword(null);

            return existsUser;
      }

}
