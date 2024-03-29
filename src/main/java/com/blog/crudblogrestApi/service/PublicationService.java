package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.dto.PublicationDTO;
import com.blog.crudblogrestApi.dto.PublicationResponse;
import com.blog.crudblogrestApi.entity.Publication;

import java.util.List;

public interface PublicationService {

//    public PublicationDTO createPublication(Long userId, Long categoryId, PublicationDTO publicationDTO);

    public PublicationDTO createPublication(Long userId, PublicationDTO publicationDTO);
    public PublicationResponse getAllPublications(int page, int size, String sortBy, String sortDir);

    public PublicationDTO getPublicationById(long id);

    List<PublicationDTO> getPublicationsByCategory(Long id);

    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id);

    public void deletePublication(long id);
}
