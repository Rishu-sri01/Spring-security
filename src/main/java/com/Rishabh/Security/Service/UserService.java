package com.Rishabh.Security.Service;

import com.Rishabh.Security.Entity.UserEntity;
import com.Rishabh.Security.Repositotry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * This service class handles user-related operations such as adding a new user and verifying user credentials.
     * */
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> addUser(String userName, String password) {
        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username and password cannot be empty.");
        }
        if (userName.length() < 3 || password.length() < 6) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Username must be at least 3 characters and password must be at least 6 characters long.");
        }
        if (userRepo.findByUserName(userName).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User " + userName + " already exists.");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(passwordEncoder.encode(password)); // Encrypt the password before saving
        userRepo.save(userEntity);
        return ResponseEntity.ok("User " + userName + " added successfully.");
    }


    public String verfy(String userName, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new dau(userName, password)
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        //TODO : Generate JWT token here and return it
        return "success";
    }
}
