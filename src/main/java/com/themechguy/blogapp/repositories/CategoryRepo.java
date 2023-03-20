package com.themechguy.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.themechguy.blogapp.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    
}
