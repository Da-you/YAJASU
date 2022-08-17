package com.sparta.prac.dto;

import com.sparta.prac.domain.Comment;
import lombok.Setter;

@Setter
public class CommentResponseDto {
    private Long postId;
    private String content;


    public CommentResponseDto(Comment comment) {
        this.postId = comment.getId();
        this.content = comment.getContent();
    }


    public Long getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }
}
