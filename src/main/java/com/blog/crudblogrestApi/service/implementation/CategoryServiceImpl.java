package com.blog.crudblogrestApi.service.implementation;

import com.blog.crudblogrestApi.entity.Category;
import com.blog.crudblogrestApi.entity.Comment;
import com.blog.crudblogrestApi.entity.Publication;
import com.blog.crudblogrestApi.exceptions.BlogException;
import com.blog.crudblogrestApi.exceptions.ResourceNotFoundException;
import com.blog.crudblogrestApi.repository.CategoryRepository;
import com.blog.crudblogrestApi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category createdCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", "id", id));
        createdCategory.setName(category.getName());
        return categoryRepository.save(createdCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        categoryRepository.delete(category);
    }
}
