package com.themechguy.blogapp.services.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.themechguy.blogapp.entities.Category;
import com.themechguy.blogapp.entities.Post;
import com.themechguy.blogapp.entities.User;
import com.themechguy.blogapp.exceptions.ResourceNotFoundException;
import com.themechguy.blogapp.payloads.PostDto;
import com.themechguy.blogapp.repositories.CategoryRepo;
import com.themechguy.blogapp.repositories.PostRepo;
import com.themechguy.blogapp.repositories.UserRepo;
import com.themechguy.blogapp.services.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CategoryRepo catRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public PostDto createPost(PostDto postDto , Long userId, Long catId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User ", "User id", userId));

        Category category = this.catRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", catId));
        
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        //to set category and user
        post.setUser(user);
        post.setCategory(category);
        // post.setTitle(postDto.getTitle());
        // post.setContent(postDto.getContent());
        Post newPost = this.postRepo.save(post);


        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {


        return null;
    }

    @Override
    public void deletePost(Long postId) {





    }

    @Override
    public List<PostDto> getAllPost() {

        return null;
    }

    @Override
    public PostDto getPostById(Long postId) {


        return null;

    }

    @Override
    public List<PostDto> getPostByCategory(Long catId) {
        Category cat= this.catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "category Id", catId));
        List<Post> postsAsList=this.postRepo.findByCategory(cat);
        //Method expects return type as PostDTO
        List<PostDto> postDtoAsList = postsAsList.stream().map((post)->this.modelMapper.map(postsAsList, PostDto.class)).collect(Collectors.toList());
        return postDtoAsList;

    }

    @Override
    public List<PostDto> getPostByUser(Long userId) {
        User users= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
        List<Post> postAsListFromUsers = this.postRepo.findByUser(users);
        //Method to return list as DTO;
        List<PostDto> postDtoAsListFromUsers= postAsListFromUsers.stream().map((userPosts)->this.modelMapper.map(postAsListFromUsers, PostDto.class)).collect(Collectors.toList());
        return postDtoAsListFromUsers;

    }

    @Override
    public List<PostDto> searchPosts(String keyword) {


        return null;

    }
    
}
