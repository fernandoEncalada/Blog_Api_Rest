package com.blog.crudblogrestApi.repository;

import com.blog.crudblogrestApi.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
