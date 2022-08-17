package com.sparta.prac.dto;

import com.sparta.prac.domain.Comment;
import com.sparta.prac.domain.Post;

import java.time.LocalDateTime;
import java.util.List;

//유저한테 보여지는 부분? 응답들을 담아주는 주머니
public class PostResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private List<CommentResponseDto> commentList;
    private LocalDateTime createdTime;


    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<CommentResponseDto> getCommentList() {
        return commentList;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }


    public PostResponseDto(Post post, List<CommentResponseDto> responseDto) {
        this.id = post.getId();
        this.author = post.getAuthor();
        this.content = post.getContent();
        this.title = post.getContent();
        this.commentList = responseDto;
        this.createdTime = post.getCreatedAt();

    }
}
