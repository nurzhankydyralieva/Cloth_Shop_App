package com.epam.AppClothShop.service;

import com.epam.AppClothShop.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);
    User updateUser(User user);
    User findByUserName(String userName);
}
