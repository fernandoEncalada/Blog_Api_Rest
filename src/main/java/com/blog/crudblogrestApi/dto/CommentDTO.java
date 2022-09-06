package com.blog.crudblogrestApi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CommentDTO {

    private long id;

    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @NotEmpty(message = "The email cannot be empty")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10, message = "The content of the comment must have least 10 characters")
    private String content;

    public CommentDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
