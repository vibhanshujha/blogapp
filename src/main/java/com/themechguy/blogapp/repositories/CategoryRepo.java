package com.themechguy.blogapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.themechguy.blogapp.entities.Category;
import com.themechguy.blogapp.entities.Post;
import com.themechguy.blogapp.entities.User;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    
    List<Post> findByUser(User user);
    List<Post>findByCategory(Category category);
    
    
}
