package com.themechguy.blogapp.services;

import java.util.*;

import com.themechguy.blogapp.payloads.UserDto;

public interface UserService {
    //method to create user
    UserDto createUser(UserDto userDto);
    //method to update user
    UserDto updateUser(UserDto userDto, Long userId);
    //method to get user by  id
    UserDto getUserById(Long userid);
    //method to get list of all user
    List<UserDto> getAllUsers();
    //delete User
    void deleteUser(Long userId);
    
}
