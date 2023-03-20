package com.themechguy.blogapp.services;

import java.util.List;

import com.themechguy.blogapp.payloads.CategoryDto;

public interface CategoryService {
    //create category
    CategoryDto addCategory(CategoryDto categoryDto);
    //update category
    CategoryDto updateCategory(CategoryDto categoryDto, Long catId);
    //delete category
    void deleteCategory(Long catId);
    //fetch all category
    List<CategoryDto> getAllcategory();
    //get category by Id
    CategoryDto getCategoryById(Long catId);
}
