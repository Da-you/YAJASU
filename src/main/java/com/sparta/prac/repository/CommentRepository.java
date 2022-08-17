package com.sparta.prac.repository;

import com.sparta.prac.domain.Comment;
import com.sparta.prac.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);


}
