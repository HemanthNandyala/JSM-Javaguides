package net.javaPrep.springboot.service;

import net.javaPrep.springboot.dto.UserDTO;
import net.javaPrep.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO  updateUserById (UserDTO user);

    void deleteUser(Long userId);
}

