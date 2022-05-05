package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.dto.CommentDTO;
import com.blog.crudblogrestApi.entity.Comment;
import com.blog.crudblogrestApi.entity.Publication;
import com.blog.crudblogrestApi.exceptions.BlogException;
import com.blog.crudblogrestApi.exceptions.ResourceNotFoundException;
import com.blog.crudblogrestApi.repository.CommentRepository;
import com.blog.crudblogrestApi.repository.PublicationRepository;
import com.blog.crudblogrestApi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public CommentDTO createComment(Long publicacionId, CommentDTO commentDTO) {
        Comment comment = mapperEntity(commentDTO);
        Publication publication = publicationRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", publicacionId));
        comment.setPublication(publication);
        Comment newComment = commentRepository.save(comment);
        return mapperDTO(newComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPublication(Long publicationId) {
        List<Comment> comments = commentRepository.findByPublicationId(publicationId);
        return comments.stream().map(comment -> mapperDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentById(Long publicationId, Long commentId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication","id", publicationId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPublication().getId().equals(publication.getId())){
            throw new BlogException(HttpStatus.BAD_REQUEST, "The comment doesn´t beLong to the publication");
        }

        return mapperDTO(comment);
    }

    @Override
    public CommentDTO updateComment(Long publicationId, Long commentId, CommentDTO commentUpdate) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", commentId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPublication().getId().equals(publication.getId())){
            throw new BlogException(HttpStatus.BAD_REQUEST, "The comment doesn´t belong to the publication");
        }

        comment.setName(commentUpdate.getName());
        System.out.println(commentUpdate.getName());
        comment.setEmail(commentUpdate.getEmail());
        System.out.println(commentUpdate.getEmail());
        comment.setContent(commentUpdate.getContent());

        Comment commentUpdated = commentRepository.save(comment);

        return mapperDTO(commentUpdated);
    }

    @Override
    public void deleteComment(Long publicationId, Long commentId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", commentId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPublication().getId().equals(publication.getId())){
            throw new BlogException(HttpStatus.BAD_REQUEST, "The comment doesn´t belong to the publication");
        }

        commentRepository.delete(comment);
    }

    private CommentDTO mapperDTO(Comment comment){
        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);

        return commentDTO;
    }

    private Comment mapperEntity(CommentDTO commentDTO){
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        return comment;
    }
}
