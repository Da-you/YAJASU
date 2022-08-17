package com.sparta.prac.controller;

import com.sparta.prac.domain.Comment;
import com.sparta.prac.dto.CommentRequestDto;
import com.sparta.prac.dto.CommentResponseDto;
import com.sparta.prac.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/comments")
    public CommentResponseDto addComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.addComment(requestDto);
    }

    @GetMapping("/api/comment/{postId}")
    public List<CommentResponseDto> readCommentList(@PathVariable Long postId){
        return commentService.readCommentList(postId);
    }
}

