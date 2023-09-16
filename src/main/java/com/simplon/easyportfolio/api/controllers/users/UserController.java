package com.simplon.easyportfolio.api.controllers.users;

import com.simplon.easyportfolio.api.services.users.UserService;
import com.simplon.easyportfolio.api.services.users.UserServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public boolean add(@RequestBody UserDTO userDTO){
        UserServiceModel userServiceModel = new UserServiceModel(userDTO.getName(),userDTO.getEmail());

        return userService.add(userServiceModel);
    }




}
