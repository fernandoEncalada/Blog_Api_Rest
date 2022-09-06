package com.blog.crudblogrestApi.controller;

import com.blog.crudblogrestApi.dto.CommentDTO;
import com.blog.crudblogrestApi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/publications/{publicationId}/comments")
    public List<CommentDTO> getCommentsByPublicationId(@PathVariable(name = "publicationId") long publicationId){
        return commentService.getCommentsByPublication(publicationId);
    }

    @GetMapping("/publications/{publicationId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(
            @PathVariable(name = "publicationId") Long publicationId,
            @PathVariable(name = "commentId") Long commentId
    ){
        CommentDTO commentDto = commentService.getCommentById(publicationId, commentId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }

    @PostMapping("/publications/{publicationId}/comments")
    public ResponseEntity<CommentDTO> createComment(
            @PathVariable(name = "publicationId") long publicationId,
            @Valid
            @RequestBody CommentDTO commentDTO
            ){
        return new ResponseEntity<>(commentService.createComment(publicationId, commentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/publications/{publicationId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(
            @PathVariable(name = "publicationId") Long publicationId,
            @PathVariable(name = "commentId") Long commentId,
            @Valid
            @RequestBody CommentDTO commentUpdate
    ){
        CommentDTO commentUpdated = commentService.updateComment(publicationId, commentId, commentUpdate);
        return new ResponseEntity<>(commentUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/publications/{publicationId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable(name = "publicationId") Long publicationId,
            @PathVariable(name = "commentId") Long commentId
    ){
        commentService.deleteComment(publicationId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
