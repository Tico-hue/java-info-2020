package com.info.myBlog.api;

import com.info.myBlog.model.Comment;
import com.info.myBlog.service.CommentService;

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

@RequestMapping("/api/v1/comment")
@RestController
public class CommentController {

    private CommentService commentService;
    
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment){
        return new ResponseEntity<>( commentService.addComment(comment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment (@PathVariable Long id, @RequestBody Comment comment){
        Comment commentToUpdate = commentService.getCommentById(id);
        return new ResponseEntity<>(commentService.updateComment(commentToUpdate,comment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id){
        Comment commentToDel = commentService.getCommentById(id);
        commentService.deleteComment(commentToDel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllComments(){
        return new ResponseEntity<>(commentService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/postComments")
    public ResponseEntity<?> getCommentsFromPost(@RequestParam Long id,@RequestParam(required = false, defaultValue = "1000000000") int number){
        return new ResponseEntity<>(commentService.getCommentsFromPost(id, number),HttpStatus.OK);
    }

}