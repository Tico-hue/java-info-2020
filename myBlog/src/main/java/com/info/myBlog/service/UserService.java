package com.info.myBlog.service;

import java.time.LocalDate;
import java.util.List;

import com.info.myBlog.DTO.UserDTO;
import com.info.myBlog.model.User;
import com.info.myBlog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    
    public UserDTO addUser(User user){
        return new UserDTO(userRepository.save(user));

    }

    public List<User> getUsersFromRcia(){
        return userRepository.findUsersFromRcia();
    }
    
    public List<User> getUsersAfterCreationDate(LocalDate creationDate){
        return userRepository.findUsersAfterCreationDate(creationDate);
    }

    public User getUserById(Long id){
        return userRepository.getOne(id);
    }
    public UserDTO updateUser(User updateU) {

        return new UserDTO(userRepository.save(updateU));
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
