package com.info.myBlog.repository;

import java.util.List;

import com.info.myBlog.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    @Query("FROM Comment c WHERE post_id = ?1 ORDER BY c.date DESC LIMIT ?2")
    List<Comment>getCommentsFromPost(Long id, Integer number);

}
    
