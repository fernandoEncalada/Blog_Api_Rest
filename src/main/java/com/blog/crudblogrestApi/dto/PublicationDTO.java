package com.blog.crudblogrestApi.dto;

import com.blog.crudblogrestApi.entity.Comment;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class PublicationDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "The title of the publication must have least 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 5, message = "The description of the publication must have least 10 characters")
    private String description;

    @NotEmpty
    private String content;

//    private Long userId;

    private Long categoryId;

    public PublicationDTO() {
        super();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
