package com.BlogApp1.service;

import com.BlogApp1.dto.ListPostDto;
import com.BlogApp1.dto.PostDto;

public interface PostService {

    public PostDto createPost(PostDto postDto);
    void deletePost(long id);
   // List<PostDto> fetchAllPosts();

    ListPostDto fetchAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    public PostDto getPostById(long id);
}
