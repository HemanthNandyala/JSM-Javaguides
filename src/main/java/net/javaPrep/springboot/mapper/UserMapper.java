package net.javaPrep.springboot.mapper;

import net.javaPrep.springboot.dto.UserDTO;
import net.javaPrep.springboot.entity.User;

public class UserMapper {

    //Convert User JPA to UserDTO
    //we have to create Static methods
    public static UserDTO mapToDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    //Convert User DTO to User JPA
    public static User mapToJpa(UserDTO userDTO){

        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;

    }
}
