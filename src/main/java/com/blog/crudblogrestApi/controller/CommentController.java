package com.blog.crudblogrestApi.controller;

import com.blog.crudblogrestApi.dto.CommentDTO;
import com.blog.crudblogrestApi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("publications/{publicationId}/comments")
    public List<CommentDTO> getCommentsByPublicationId(@PathVariable(name = "publicationId") long publicationId){
        return commentService.getCommentsByPublication(publicationId);
    }

    @PostMapping("publications/{publicationId}/comments")
    public ResponseEntity<CommentDTO> createComment(
            @PathVariable(name = "publicationId") long publicationId,
            @RequestBody CommentDTO commentDTO
            ){
        return new ResponseEntity<>(commentService.createComment(publicationId, commentDTO), HttpStatus.CREATED);
    }
}
