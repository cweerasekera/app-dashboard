package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.User;

import java.util.List;

/**
 * Created by cweerasekera
 */
public interface UserRepo {
    public List<User> findAllUsers();
    public User findUser(String uuid);
    public User findUserByUserName(String username);
    //public User findUserByOpenId(String openIdIdentifier);
    public User createUser(User data);
}
