package com.BlogApp1.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostWithCommentDto {


    private PostDto post;
    private List<CommentDto> commentDto = new ArrayList<>();
}
//this PostWithCommentDto will return a post along with list of comment{ List<CommentDto> commentDto}.