package com.themechguy.blogapp.services.serviceImpl;

import java.util.Date;
import java.util.List;

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


        return null;

    }

    @Override
    public List<PostDto> getPostByUser(Long userId) {


        return null;

    }

    @Override
    public List<PostDto> searchPosts(String keyword) {


        return null;

    }
    
}
