package com.Rishabh.Security.Service;

import com.Rishabh.Security.Entity.UserEntity;
import com.Rishabh.Security.Repositotry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserdetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> user = userRepo.findByUserName(username);
        if (user.isPresent()) {
            UserEntity userEntity = user.get();
            return org.springframework.security.core.userdetails.User
                    .withUsername(userEntity.getUserName())
                    .password(userEntity.getPassword())
                    .authorities("USER") // You can set roles or authorities here
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
