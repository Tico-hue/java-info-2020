package com.info.myBlog.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.info.myBlog.model.Comment;
import com.info.myBlog.model.Post;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private String body;
    private UserDTO userDTO;
    private LocalDate creationDate;
    private Boolean published; 
    private List<CommentDTO> commentsDTO;
    
    public PostDTO(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.body = post.getBody();
        this.userDTO = new UserDTO(post.getAuthor());
        this.creationDate = post.getCreationDate();
        this.published = post.getPublished();
        this.commentsDTO = getCommentsDTO(post);
    }

    public List<CommentDTO> getCommentsDTO(Post post) {
        return post.getComments().stream()
        .map((Comment commentDto)-> new CommentDTO(
                commentDto.getId(),
                commentDto.getBody(),
                commentDto.getDate())).collect(Collectors.toList());
    }

    public PostDTO(Long id, String title, String description, String body, UserDTO userDto, LocalDate dateCreated, Boolean published, List<CommentDTO> commentDTO) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
        this.userDTO = userDto;
        this.creationDate = dateCreated;
        this.published = published;
        this.commentsDTO = commentDTO;
    }

    public PostDTO(Long id, String title, String description, String body, UserDTO userDto, LocalDate dateCreated, Boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
        this.userDTO = userDto;
        this.creationDate = dateCreated;
        this.published = published;
    }
    

    public PostDTO(){}
    public PostDTO(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public List<CommentDTO> getCommentsDTO() {
        return commentsDTO;
    }

    public void setCommentsDTO(List<CommentDTO> commentsDTO) {
        this.commentsDTO = commentsDTO;
    }


   
}
