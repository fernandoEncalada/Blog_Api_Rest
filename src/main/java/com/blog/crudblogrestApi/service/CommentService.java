package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    public CommentDTO createComment(Long publicacionId, CommentDTO commentDTO);

    public List<CommentDTO> getCommentsByPublication(Long publicationId);

    public CommentDTO getCommentById(Long publicationId, Long commentId);

    public CommentDTO updateComment(Long publicationId, Long commentId, CommentDTO commentUpdate);

    public void deleteComment(Long publicationId, Long commentId);
}
