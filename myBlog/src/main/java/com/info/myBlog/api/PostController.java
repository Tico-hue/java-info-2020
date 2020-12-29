package com.info.myBlog.api;

import com.info.myBlog.model.Post;
import com.info.myBlog.service.PostService;

import org.apache.catalina.connector.Response;
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

@RequestMapping("/api/v1/post")
@RestController
public class PostController {

    private PostService postService;
    
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody Post post){
        return new ResponseEntity<>( postService.addPost(post), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost (@PathVariable Long id, @RequestBody Post post){
        Post postToUpdate = postService.getPostById(id);
        return new ResponseEntity<>(postService.updatePost(postToUpdate,post),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        Post postToDel = postService.getPostById(id);
        postService.deletePost(postToDel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllPosts(){
        return new ResponseEntity<>(postService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getPostsByWord(@RequestParam String word){
        return new ResponseEntity<> (postService.getPostByWord(word),HttpStatus.OK);
    }

    @GetMapping("/notPublished")
    public ResponseEntity<?> getPostsNotPublished(){
        return new ResponseEntity<>(postService.getPostsNotPublished(),HttpStatus.OK)
    }

}