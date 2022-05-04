package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    public CommentDTO createComment(long publicacionId, CommentDTO commentDTO);

    public List<CommentDTO> getCommentsByPublication(long publicationId);

    public CommentDTO getCommentById(long publicationId, long commentId);
}
