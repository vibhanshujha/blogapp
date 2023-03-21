package com.themechguy.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.themechguy.blogapp.entities.Category;
import com.themechguy.blogapp.entities.Post;
import com.themechguy.blogapp.entities.User;

import java.util.*;

public interface PostRepo extends JpaRepository<Post, Long>{
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    
}
