package com.themechguy.blogapp.services;

import java.util.List;

import com.themechguy.blogapp.entities.Post;
import com.themechguy.blogapp.payloads.PostDto;

public interface PostService {
    Post createPost(PostDto postDto);
    Post updatePost(PostDto postDto, Long postId);
    void deletePost(Long postId);
    List<Post>getAllPost();
    Post getPostById(Long postId);
    List<Post> getPostByCategory(Long catId);
    List<Post> getPostByUser(Long userId);
    List<Post> searchPosts(String keyword);
}
