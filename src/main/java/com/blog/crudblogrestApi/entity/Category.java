package com.blog.crudblogrestApi.entity;

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

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Set<Publication> publications = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name, Set<Publication> publications) {
        this.id = id;
        this.name = name;
//        this.publications = publications;
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

//    public Set<Publication> getPublications() {
//        return publications;
//    }
//
//    public void setPublications(Set<Publication> publications) {
//        this.publications = publications;
//    }
}
