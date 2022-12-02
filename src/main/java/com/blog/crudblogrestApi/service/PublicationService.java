package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.dto.PublicationDTO;
import com.blog.crudblogrestApi.dto.PublicationResponse;

import java.util.List;

public interface PublicationService {

    public PublicationDTO createPublication(Long userId, PublicationDTO publicationDTO);

    public PublicationResponse getAllPublications(int page, int size, String sortBy, String sortDir);

    public PublicationDTO getPublicationById(long id);

    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id);

    public void deletePublication(long id);
}
