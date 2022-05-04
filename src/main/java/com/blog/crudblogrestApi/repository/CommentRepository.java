package com.blog.crudblogrestApi.repository;

import com.blog.crudblogrestApi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByPublicationId(long publicationId);
}
