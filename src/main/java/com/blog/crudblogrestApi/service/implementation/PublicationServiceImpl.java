package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.dto.PublicationDTO;
import com.blog.crudblogrestApi.dto.PublicationResponse;
import com.blog.crudblogrestApi.entity.Category;
import com.blog.crudblogrestApi.entity.Publication;
import com.blog.crudblogrestApi.entity.User;
import com.blog.crudblogrestApi.exceptions.ResourceNotFoundException;
import com.blog.crudblogrestApi.repository.CategoryRepository;
import com.blog.crudblogrestApi.repository.PublicationRepository;
import com.blog.crudblogrestApi.repository.UserRepository;
import com.blog.crudblogrestApi.service.PublicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public PublicationDTO createPublication(Long userId, PublicationDTO publicationDTO) {
        // Convert dto to entity
        Publication publication = mapperEntity(publicationDTO);
        User user = userRepository.findById(userId).orElse(null);
        publication.setUser(user);

        Category category = categoryRepository.findById(publicationDTO.getCategoryId()).orElse(null);
        publication.setCategory(category);

        Publication newPublication = publicationRepository.save(publication);

        //Convert entity to DTO
        PublicationDTO publicationResponse = mapperDTO(newPublication);

        return publicationResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public PublicationResponse getAllPublications(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Publication> publications = publicationRepository.findAll(pageable);

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
    @Transactional(readOnly = true)
    public PublicationDTO getPublicationById(long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));
        return mapperDTO(publication);
    }

    @Override
    public List<PublicationDTO> getPublicationsByCategory(Long id) {
        List<Publication> publications = publicationRepository.findAll();
        List<PublicationDTO> publicationsMapped = publications.stream().map(this::mapToDto).collect(Collectors.toList());
        return publicationsMapped.stream().filter(pm -> pm.getCategoryId().equals(id)).collect(Collectors.toList());
    }

    private PublicationDTO mapToDto(Publication publication) {
        PublicationDTO publicationDTO = new PublicationDTO();
        publicationDTO.setId(publication.getId());
        publicationDTO.setContent(publication.getContent());
        publicationDTO.setPicture(publication.getPicture());
        publicationDTO.setTitle(publication.getTitle());
        publicationDTO.setCategoryId(publication.getCategory().getId());
        return publicationDTO;
    }

    @Override
    @Transactional
    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));

        publication.setTitle(publicationDTO.getTitle());
        publication.setContent(publicationDTO.getContent());
        publication.setPicture(publicationDTO.getPicture());
        System.out.println(publicationDTO.getCategoryId());
        Category category = categoryRepository.findById(publicationDTO.getCategoryId()).orElse(null);
        publication.setCategory(category);

        Publication publicationUpdated = publicationRepository.save(publication);
        return mapperDTO(publicationUpdated);
    }

    @Override
    @Transactional
    public void deletePublication(long id) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", id));
        publicationRepository.delete(publication);
    }

    // Convert entity to DTO
    private PublicationDTO mapperDTO(Publication publication){
        PublicationDTO publicationDTO = modelMapper.map(publication, PublicationDTO.class);
        return publicationDTO;
    }

    // Convert dto to entity
    private Publication mapperEntity(PublicationDTO publicationDTO){
        Publication publication = modelMapper.map(publicationDTO, Publication.class);

        return publication;
    }
}
