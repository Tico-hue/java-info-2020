package com.info.myBlog.api;

import java.time.LocalDate;


import com.info.myBlog.model.User;
import com.info.myBlog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<> (userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/rcia")
    public ResponseEntity<?> getUsersFromRcia(){
        return new ResponseEntity<>(userService.getUsersFromRcia(),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> getUserAfterDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(userService.getUsersAfterCreationDate(date), HttpStatus.OK); 
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser (@PathVariable Long id, @RequestBody User user){
        User userToUpdate = userService.getUserById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setCountry(user.getCountry());
        userToUpdate.setState(user.getState());
        userToUpdate.setCity(user.getCity()); 
        return new ResponseEntity<>(userService.updateUser(userToUpdate), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        User userToDel = userService.getUserById(id);
        userService.deleteUser(userToDel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

