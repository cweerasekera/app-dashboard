package com.appdirect.backend.core.services;

import com.appdirect.backend.core.entities.User;

import java.util.List;

/**
 * Created by cweerasekera
 */
public interface UserService {
    public List<User> findAllUsers();
    public User findUser(String uuid);
    public User findUserByUserName(String username);
    //public User findUserByOpenId(String openIdIdentifier);
    public User createUser(User data);
}
