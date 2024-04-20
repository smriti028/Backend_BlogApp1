package com.BlogApp1.repository;

import com.BlogApp1.dto.CommentDto;
import com.BlogApp1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
     List<Comment> findByPostId(long postId);
}
