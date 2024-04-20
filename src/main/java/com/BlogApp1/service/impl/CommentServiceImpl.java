package com.BlogApp1.service.impl;

import com.BlogApp1.dto.CommentDto;
import com.BlogApp1.dto.PostDto;
import com.BlogApp1.dto.PostWithCommentDto;
import com.BlogApp1.entity.Comment;
import com.BlogApp1.entity.Post;
import com.BlogApp1.repository.CommentRepository;
import com.BlogApp1.repository.PostRepository;
import com.BlogApp1.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;
    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();

        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

    public PostWithCommentDto getAllCommentsByPostId(long id){
        Post post = postRepository.findById(id).get();
        //with the post id , we're getting post

        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        List<Comment> comments = commentRepository.findByPostId(id);
        List<CommentDto> dtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        PostWithCommentDto postWithCommentDto = new PostWithCommentDto();
        ////with the postId, we're getting the comments form the comment table


        postWithCommentDto.setCommentDto(dtos);
        postWithCommentDto.setPost(dto);
        //here we're returning comment and the post in 1 Dto

        return  postWithCommentDto;
    }

    Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto,Comment.class);
        return comment;
    }
    CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
        return commentDto;

    }


}
