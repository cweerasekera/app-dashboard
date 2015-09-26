package com.appdirect.backend.core.services.impl;

import com.appdirect.backend.core.entities.User;
import com.appdirect.backend.core.repositories.UserRepo;
import com.appdirect.backend.core.services.UserService;
import com.appdirect.backend.core.services.exceptions.UserDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cweerasekera
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAllUsers();
    }

    @Override
    public User findUser(String uuid) {
        return userRepo.findUser(uuid);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepo.findUserByUserName(username);
    }

    /*@Override
    public User findUserByOpenId(String openIdIdentifier) {
        return userRepo.findUserByOpenId(openIdIdentifier);
    }*/

    @Override
    public User createUser(User data) {
        User user = userRepo.findUser(data.getUuid());
        if(user == null){
            throw new UserDoesNotExistsException();
        }
        return userRepo.createUser(data);
    }
}
