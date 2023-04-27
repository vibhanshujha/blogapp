package com.themechguy.blogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.themechguy.blogapp.payloads.PostDto;
import com.themechguy.blogapp.services.PostService;



@RestController
@RequestMapping("/api/")
public class postController {

    @Autowired
    PostService postService;

    //create post method

    @PostMapping("/user/{userId}/category/{catId}/posts")
    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto, @PathVariable Long userId, @PathVariable Long catId){
        PostDto createdPost =this.postService.createPost(postDto, userId, catId);

        return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
    }
    // get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId){
        List<PostDto> posts =this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);   
    }
    //get posts by category
    @GetMapping("/category/{catId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long catId){
        List<PostDto> posts =this.postService.getPostByCategory(catId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);}
}
