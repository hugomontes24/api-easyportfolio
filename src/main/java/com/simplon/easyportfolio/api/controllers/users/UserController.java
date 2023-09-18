package com.simplon.easyportfolio.api.controllers.users;

import com.simplon.easyportfolio.api.exceptions.UserNotFoundException;
import com.simplon.easyportfolio.api.repositories.users.UserRepositoryModel;
import com.simplon.easyportfolio.api.services.users.UserService;
import com.simplon.easyportfolio.api.services.users.UserServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ArrayList<UserGetDTO> findAll(){
        ArrayList<UserGetDTO> userGetDTOS = new ArrayList<>();
        ArrayList<UserServiceModel> userServiceModels = userService.findAll();
        userServiceModels.forEach( (item)->userGetDTOS.add(new UserGetDTO(item.getId().get(), item.getName(), item.getFirstname(),item.getEmail())) );

        return userGetDTOS;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<UserGetDTO> findById(@PathVariable Long id){
       // UserGetDTO userGetDTO= new UserGetDTO();
        try{
            UserServiceModel userServiceModel=userService.findById(id);
            UserGetDTO userGetDTO= new UserGetDTO(userServiceModel.getId().get(), userServiceModel.getName(), userServiceModel.getFirstname(), userServiceModel.getEmail());
            return new ResponseEntity<>(userGetDTO, HttpStatus.OK);
        }catch(UserNotFoundException ex){
            System.out.println(ex.getReason());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getReason());
        }

    }



}
