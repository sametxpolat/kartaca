package com.kartaca.softwaredeveloper.service.middleware;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
      
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      public String encoder(String password) {
            return encoder.encode(password);
      }

      public Boolean decoder(String password, String pass) {
            return encoder.matches(password, pass);
      }

      // > generate unique id for user redis key. 
      public String uniqueIdGenerator() {
            UUID uuid = UUID.randomUUID();

            return uuid.toString();
      }

}
