package com.themechguy.blogapp.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themechguy.blogapp.entities.User;
import com.themechguy.blogapp.repositories.UserRepo;
import com.themechguy.blogapp.services.UserService;
import com.themechguy.blogapp.exceptions.ResourceNotFoundException;
import com.themechguy.blogapp.payloads.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
        //  
        // throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        //Storing the updated user based on userId
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        // need to set values
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        //changes will be added for encrypted and decrypted password in future 
        user.setPassword(userDto.getPassword());
        User updateUser = this.userRepo.save(user);

        return this.userToDto(updateUser);
    }

    @Override
    public UserDto getUserById(Long userid) {
        // 
        User user = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User","Id", userid));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // fetch all user and store it into list
        List<User> users = this.userRepo.findAll();
        //converting users to userdto
        List<UserDto> allUsersAsDto=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return allUsersAsDto;
    }

    @Override
    public void deleteUser(Long userid) {
        // throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
        User user = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User","Id", userid));
        this.userRepo.delete(user);
    }


    //Since service uses UserDto for transaction and repository uses user for sending the details. Handling mapping of the usertoDto and dtoToUser.
    //Binding result from dto to user for functioning of repo method
    private User dtoToUser(UserDto userDto){
        //Hardcoded mapping---
        // User user = new User();
        // user.setId(userDto.getId());
        // user.setName(userDto.getName());
        // user.setEmail(userDto.getEmail());
        // user.setAbout(userDto.getAbout());
        // user.setPassword(userDto.getPassword());
        User user = this.modelMapper.map(userDto,User.class);
        return user;
    }
    //Binding result of user to dto.
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    
}
