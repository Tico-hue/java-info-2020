package com.info.myBlog.repository;

import java.time.LocalDate;
import java.util.List;

import com.info.myBlog.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("FROM User WHERE city LIKE 'resistencia'")
    List<User>findUsersFromRcia();

    @Query("FROM User WHERE creationDate > ?1")
    List<User>findUsersAfterCreationDate(LocalDate aDate);
    
    
}
