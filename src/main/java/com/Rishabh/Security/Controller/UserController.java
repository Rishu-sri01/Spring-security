package com.Rishabh.Security.Controller;

import com.Rishabh.Security.Entity.UserEntity;
import com.Rishabh.Security.Service.UserService;
import com.Rishabh.Security.dto.UserAuthReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserAuthReq userAuthReq) {
        return userService.addUser( userAuthReq.getUserName(), userAuthReq.getPassword());
    }

    @PostMapping("/loginn")
    public String login(UserEntity userEntity) {
        return  userService.verfy(userEntity.getUserName(), userEntity.getPassword());
    }

}
