package com.themechguy.blogapp.services;

import java.util.List;

import com.themechguy.blogapp.payloads.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto, Long userId, Long catId);
    PostDto updatePost(PostDto postDto, Long postId);
    void deletePost(Long postId);
    List<PostDto>getAllPost();
    PostDto getPostById(Long postId);
    List<PostDto> getPostByCategory(Long catId);
    List<PostDto> getPostByUser(Long userId);
    List<PostDto> searchPosts(String keyword);
}
