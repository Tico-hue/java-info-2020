package com.info.myBlog.repository;

import java.util.List;

import com.info.myBlog.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:palabra%")
    List<Post>getPostsByWord(@Param("palabra") String palabra);

    @Query("SELECT p FROM Post p WHERE p.published = 0")
    List<Post>getPostsNotPublished();
    
}
    
