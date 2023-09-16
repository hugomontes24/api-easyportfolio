package com.simplon.easyportfolio.api.services.users;

import com.simplon.easyportfolio.api.repositories.users.UserRepository;
import com.simplon.easyportfolio.api.repositories.users.UserRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean add(UserServiceModel userServiceModel) {
        UserRepositoryModel userRepositoryModel = new UserRepositoryModel( userServiceModel.getName(), userServiceModel.getEmail());
        UserRepositoryModel userRepositoryReturn = userRepository.save(userRepositoryModel);

        return userRepositoryReturn != null;
    }
}
