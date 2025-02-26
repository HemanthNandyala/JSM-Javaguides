package net.javaPrep.springboot.controller;

import net.javaPrep.springboot.dto.UserDTO;
import net.javaPrep.springboot.entity.User;
import net.javaPrep.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        UserDTO savedUser = userService.createUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    //http://localhost:8086/api/user/5
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId){
       UserDTO userDTO = userService.getUserById(userId);
       return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping
    //http://localhost:8086/api/user
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("{id}")
    //http://localhost:8086/api/user/3
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId, @RequestBody UserDTO user){
        user.setId(userId);
       UserDTO updatedUser = userService.updateUserById(user);

       return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    //http://localhost:8086/api/user/1
    public ResponseEntity<String> deleteUserbyId(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully" , HttpStatus.OK);
    }


}
