package com.info.myBlog.service;

import java.util.List;

import com.info.myBlog.DTO.CommentDTO;
import com.info.myBlog.model.Comment;
import com.info.myBlog.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }
    public List<Comment> getCommentsFromPost(Long id, Integer number){
        return commentRepository.getCommentsFromPost(id,number);
    }
    public CommentDTO addComment(Comment comment){
        return new CommentDTO(commentRepository.save(comment));
    }

    public Comment getCommentById(Long id){
        return commentRepository.getOne(id);
    }

    public CommentDTO updateComment(Comment commentToUpdate,Comment comment ){
        commentToUpdate.setBody(comment.getBody());
        return new CommentDTO(commentRepository.save(commentToUpdate));
    }

    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }
    

}
