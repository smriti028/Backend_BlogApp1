package com.BlogApp1.service;

import com.BlogApp1.dto.CommentDto;
import com.BlogApp1.dto.PostWithCommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long postId);
    public PostWithCommentDto getAllCommentsByPostId(long id);
}
