package com.blog.crudblogrestApi.service;

import com.blog.crudblogrestApi.entity.Category;

import java.util.List;

public interface CategoryService {

    public Category saveCategory(Category category);

    public List<Category> getCategories();

    public Category getCategoryById(Long id);

    public Category updateCategory(Category category, Long id );

    public void deleteCategory(Long id);
}
