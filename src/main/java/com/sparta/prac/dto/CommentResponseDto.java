package com.sparta.prac.dto;

import com.sparta.prac.domain.Comment;
import lombok.Setter;

@Setter
public class CommentResponseDto {
    private Long id;
    private String content;


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }


    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
