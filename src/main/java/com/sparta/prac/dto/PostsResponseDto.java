package com.sparta.prac.dto;

import com.sparta.prac.domain.Post;

import java.time.LocalDateTime;

public class PostsResponseDto {

    private String author;
    private String title;
    private String content;
    private LocalDateTime createdTime;

    private Integer commentListCnt;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Integer getCommentListCnt() {
        return commentListCnt;
    }
    public PostsResponseDto(Post post,Integer commentListCnt) {
        this.author = post.getAuthor();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdTime = post.getCreatedAt();
        this.commentListCnt = commentListCnt;
    }
}
