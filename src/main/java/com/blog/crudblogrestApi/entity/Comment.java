package com.blog.crudblogrestApi.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication_id" , nullable = false)
    private Publication publication;

    public Comment() {
    }

    public Comment(long id, String name, String email, String content, Publication publication) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.content = content;
        this.publication = publication;
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

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
