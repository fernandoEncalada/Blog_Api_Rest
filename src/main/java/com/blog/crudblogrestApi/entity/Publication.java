package com.blog.crudblogrestApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publications", uniqueConstraints = { @UniqueConstraint(columnNames = "title")})
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Lob
    @Column(name="content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name="picture")
    private String picture;

    @JsonBackReference
    @OneToMany(mappedBy = "publication")
    private Set<Comment> comments = new HashSet<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Publication() {
        super();
    }

    public Publication(Long id, String title, String content, Date createdAt, User user, String picture) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = createdAt;
        this.picture = picture;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @PrePersist
    private void prePersistDate(){
        setCreatedAt(new Date());
    }
}
