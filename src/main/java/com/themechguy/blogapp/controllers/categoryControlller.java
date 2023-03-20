package com.themechguy.blogapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.themechguy.blogapp.payloads.ApiResponse;
import com.themechguy.blogapp.payloads.CategoryDto;
import com.themechguy.blogapp.services.CategoryService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/categories")
public class categoryControlller {

    @Autowired
    CategoryService categoryService;

    //Post category
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategoryDto= this.categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }
    //Update Category
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateTheCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Long catId){
        CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, catId);
        return ResponseEntity.ok(updateCategoryDto);
    }
    //Delete Category
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully",true), HttpStatus.OK);
    }
    //Fectch category
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> fetchAllCategory(){
        return ResponseEntity.ok(this.categoryService.getAllcategory());
    }
    //Fetch by Id
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long catId){
        return ResponseEntity.ok(this.categoryService.getCategoryById(catId));
    }

    
}
