package com.info.myBlog.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.info.myBlog.model.Comment;
import com.info.myBlog.model.User;
import com.info.myBlog.model.Post;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate creationDate;
    private String city;
    private String state;
    private String country;
    private List<PostDTO> postDTO;
    private List<CommentDTO> commentDTO;    

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.creationDate = user.getCreationDate();
        this.city = user.getCity();
        this.state = user.getState();
        this.country = user.getCountry();
        this.commentDTO = getComments(user);
        this.postDTO = getPosts(user);

    }
    public List<CommentDTO> getComments(User user){
        return user.getComments().stream()
        .map((Comment commentDto) -> new CommentDTO(
                commentDto.getId(),
                commentDto.getBody(), commentDto.getDate()))
        .collect(Collectors.toList());

    }
    private List<PostDTO> getPosts(User user) {
        return user.getPosts().stream()
                .map((Post postDTO) -> new PostDTO(
                        postDTO.getId(),
                        postDTO.getTitle(),
                        postDTO.getDescription(),
                        postDTO.getBody(),
                        new UserDTO(
                                postDTO.getAuthor().getId()),
                        postDTO.getCreationDate(),
                        postDTO.getPublished(),
                        postDTO.getComments().stream()
                                .map(CommentDTO::new)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public UserDTO(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PostDTO> getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(List<PostDTO> postDTO) {
        this.postDTO = postDTO;
    }

    public List<CommentDTO> getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(List<CommentDTO> commentDTO) {
        this.commentDTO = commentDTO;
    }


}
