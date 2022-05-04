package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.dto.CommentDTO;
import com.blog.crudblogrestApi.entity.Comment;
import com.blog.crudblogrestApi.entity.Publication;
import com.blog.crudblogrestApi.exceptions.ResourceNotFoundException;
import com.blog.crudblogrestApi.repository.CommentRepository;
import com.blog.crudblogrestApi.repository.PublicationRepository;
import com.blog.crudblogrestApi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public CommentDTO createComment(long publicacionId, CommentDTO commentDTO) {
        Comment comment = mapperEntity(commentDTO);
        Publication publication = publicationRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", publicacionId));
        comment.setPublication(publication);
        Comment newComment = commentRepository.save(comment);
        return mapperDTO(newComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPublication(long publicationId) {
        List<Comment> comments = commentRepository.findByPublicationId(publicationId);
        return comments.stream().map(comment -> mapperDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(long publicationId, long commentId) {
        return null;
    }

    private CommentDTO mapperDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setEmail(comment.getEmail());
        commentDTO.setContent(comment.getContent());

        return commentDTO;
    }

    private Comment mapperEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setContent(commentDTO.getContent());

        return comment;
    }
}
