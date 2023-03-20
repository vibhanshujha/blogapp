package com.themechguy.blogapp.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.themechguy.blogapp.entities.Category;
import com.themechguy.blogapp.exceptions.ResourceNotFoundException;
import com.themechguy.blogapp.payloads.CategoryDto;
import com.themechguy.blogapp.repositories.CategoryRepo;
import com.themechguy.blogapp.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepo catRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category= this.dtoToCategory(categoryDto);
        Category savedCategory= this.catRepo.save(category);
        return this.categoryToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long catId) {
        Category category= this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", catId));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        Category updateCategory= this.catRepo.save(category);
        return this.categoryToDto(updateCategory);
    }

    @Override
    public void deleteCategory(Long catId) {
        Category category= this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", catId));
        this.catRepo.delete(category);

    }

    @Override
    public List<CategoryDto> getAllcategory() {
        List<Category> categories = this.catRepo.findAll();
        List<CategoryDto> allCategoryAsDto = categories.stream().map((c)->this.categoryToDto(c)).collect(Collectors.toList());
        return allCategoryAsDto;

    }

    @Override
    public CategoryDto getCategoryById(Long catId) {
        Category category= this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", catId));
        return this.categoryToDto(category);

    }

    //Mapper implementation
    public Category dtoToCategory(CategoryDto categoryDto){
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return category;
    }
    public CategoryDto categoryToDto(Category category){
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}
