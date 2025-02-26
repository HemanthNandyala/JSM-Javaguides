package net.javaPrep.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaPrep.springboot.dto.UserDTO;
import net.javaPrep.springboot.entity.User;
import net.javaPrep.springboot.mapper.UserMapper;
import net.javaPrep.springboot.repository.UserRepository;
import net.javaPrep.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO){
        //convert UserDto into User JPA entity
        User user = UserMapper.mapToJpa(userDTO);
        User savedUser = userRepository.save(user);

        //Convert JPA entity to UserDTO
        UserDTO savedUserDTO = UserMapper.mapToDTO(savedUser);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionaled =  userRepository.findById(userId);
        User user = optionaled.get() ;
        return UserMapper.mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
       List<User> users = userRepository.findAll();
       //Logic to convert List of User object to ListOf UserDto objects
        return users.stream().map(UserMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUserById(UserDTO user) {
       User existingUser = userRepository.findById(user.getId()).get();
       existingUser.setFirstName(user.getFirstName());
       existingUser.setLastName(user.getLastName());
       existingUser.setEmail(user.getEmail());
       User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToDTO(updatedUser) ;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
