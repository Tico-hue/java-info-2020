package com.info.myBlog.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.info.myBlog.model.Comment;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private Long id;
    private String body;
    private LocalDate date;

    public CommentDTO(Long id){
        this.id = id;
    }
    
    public CommentDTO(Comment comment){
        this.id = comment.getId();
        this.body = comment.getBody();
    }

    public CommentDTO(Long id, String body, LocalDate date){
        this.id = id;
        this.body = body;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
