package net.javaPrep.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaPrep.springboot.entity.User;
import net.javaPrep.springboot.repository.UserRepository;
import net.javaPrep.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionaled =  userRepository.findById(userId);
        return optionaled.get();

    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User updateUserById(User user) {
       User existingUser = userRepository.findById(user.getId()).get();
       existingUser.setFirstName(user.getFirstName());
       existingUser.setLastName(user.getLastName());
       existingUser.setEmail(user.getEmail());
       User updatedUser = userRepository.save(existingUser);
        return updatedUser ;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
