package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.dto.PublicationDTO;
import com.blog.crudblogrestApi.dto.PublicationResponse;
import com.blog.crudblogrestApi.entity.Publication;
import com.blog.crudblogrestApi.exceptions.ResourceNotFoundException;
import com.blog.crudblogrestApi.repository.PublicationRepository;
import com.blog.crudblogrestApi.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDTO) {
        // Convert dto to entity
        Publication publication = mapperEntity(publicationDTO);

        Publication newPublication = publicationRepository.save(publication);

        //Convert entity to DTO
        PublicationDTO publicationResponse = mapperDTO(newPublication);

        return publicationResponse;
    }

    @Override
    public PublicationResponse getAllPublications(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Publication> publications = publicationRepository.findAll(pageable);

        List<Publication> publicationList = publications.getContent();
        List<PublicationDTO> content = publications.stream().map(publication -> mapperDTO(publication)).collect(Collectors.toList());

        PublicationResponse publicationResponse = new PublicationResponse();
        publicationResponse.setContent(content);
        publicationResponse.setPage(publications.getNumber());
        publicationResponse.setSize(publications.getSize());
        publicationResponse.setTotalPublications(publications.getTotalElements());
        publicationResponse.setTotalPages(publications.getTotalPages());
        publicationResponse.setLast(publications.isLast());

        return publicationResponse;


    }

    @Override
    public PublicationDTO getPublicationById(long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));
        return mapperDTO(publication);
    }

    @Override
    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));

        publication.setTitle(publicationDTO.getTitle());
        publication.setDescription(publicationDTO.getDescription());
        publication.setContent(publicationDTO.getContent());

        Publication publicationUpdated = publicationRepository.save(publication);
        return mapperDTO(publicationUpdated);
    }

    @Override
    public void deletePublication(long id) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));
        publicationRepository.delete(publication);
    }

    // Convert entity to DTO
    private PublicationDTO mapperDTO(Publication publication){
        PublicationDTO publicationDTO = new PublicationDTO();

        publicationDTO.setId(publication.getId());
        publicationDTO.setTitle(publication.getTitle());
        publicationDTO.setDescription(publication.getDescription());
        publicationDTO.setContent(publication.getContent());

        return publicationDTO;
    }

    // Convert dto to entity
    private Publication mapperEntity(PublicationDTO publicationDTO){
        Publication publication = new Publication();

        publication.setTitle(publicationDTO.getTitle());
        publication.setDescription(publicationDTO.getDescription());
        publication.setContent(publicationDTO.getContent());

        return publication;
    }
}
