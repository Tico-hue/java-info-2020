package com.info.myBlog.service;

import java.util.List;

import com.info.myBlog.DTO.PostDTO;
import com.info.myBlog.model.Post;
import com.info.myBlog.repository.PostRepository;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }
    public List<Post> getPostByWord(String word){
        return postRepository.getPostsByWord(word);
    }
    public PostDTO addPost(Post post){
        return new PostDTO(postRepository.save(post));
    }

    public Post getPostById(Long id){
        return postRepository.getOne(id);
    }

    public PostDTO updatePost(Post postToUpdate,Post post ){
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setDescription(post.getDescription());
        postToUpdate.setBody(post.getBody());
        postToUpdate.setPublished(post.getPublished());
        return new PostDTO(postRepository.save(postToUpdate));
    }

    public void deletePost(Post post){
        postRepository.delete(post);
    }
    
    public List<Post> getPostsNotPublished(){
        return postRepository.getPostsNotPublished();
    }
}
