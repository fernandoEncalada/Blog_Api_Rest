package com.blog.crudblogrestApi.controller;

import com.blog.crudblogrestApi.dto.PublicationDTO;
import com.blog.crudblogrestApi.dto.PublicationResponse;
import com.blog.crudblogrestApi.service.PublicationService;
import com.blog.crudblogrestApi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@Valid @RequestBody PublicationDTO publicationDTO){
        return new ResponseEntity<>(publicationService.createPublication(publicationDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public PublicationResponse getPublications(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE, required = false) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE, required = false) int size,
            @RequestParam(value = "sort", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
        return publicationService.getAllPublications(page, size, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> getPublicationById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(publicationService.getPublicationById(id));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> updatePublication(@Valid @RequestBody PublicationDTO publicationDTO, @PathVariable(name = "id") long id){
        PublicationDTO publicationResponse = publicationService.updatePublication(publicationDTO, id);
        return new ResponseEntity<>(publicationResponse,HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable(name= "id") long id){
        publicationService.deletePublication(id);
        return new ResponseEntity<>("Publication deleted", HttpStatus.OK);
    }
}