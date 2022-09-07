package com.blog.crudblogrestApi.repository;

import com.blog.crudblogrestApi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
