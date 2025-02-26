package net.javaPrep.springboot.service;

import net.javaPrep.springboot.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long userId);

    List<User> getAllUsers();

    User  updateUserById (User user);

    void deleteUser(Long userId);
}

