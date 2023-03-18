package com.themechguy.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.themechguy.blogapp.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
