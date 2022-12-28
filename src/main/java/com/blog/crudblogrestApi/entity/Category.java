package com.blog.crudblogrestApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

//    @JsonBackReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "category")
//    private Set<Publication> publications = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
//        this.publications = publications;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Publication> getPublications() {
//        return publications;
//    }
//
//    public void setPublications(Set<Publication> publications) {
//        this.publications = publications;
//    }
}
