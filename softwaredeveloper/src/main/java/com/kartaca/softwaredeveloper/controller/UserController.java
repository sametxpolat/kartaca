package com.kartaca.softwaredeveloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartaca.softwaredeveloper.model.User;
import com.kartaca.softwaredeveloper.service.UserService;
import com.kartaca.softwaredeveloper.service.middleware.SecurityService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
      
      @Autowired
      private UserService userService;
      
      @Autowired
      private SecurityService securityService;

      @PostMapping("/set")
      public ResponseEntity<?> setUser(@RequestBody User user) {
            if(!userService.setUser(user)) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            return ResponseEntity.status(HttpStatus.OK).build();
      }

      @GetMapping("/get")
      public ResponseEntity<User> getUser(@RequestBody User user) {
            String email = user.getEmail();
            String password = user.getPassword();
            String uniqueId = user.getUniqueId();

            if(user.getUniqueId() == null) {
                  uniqueId = securityService.uniqueIdGenerator();
            }

            User getedUser = userService.getUser(email, password, uniqueId);
            
            return ResponseEntity.status(HttpStatus.OK).body(getedUser);
      }

}
