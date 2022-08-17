package com.sparta.prac.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.prac.dto.CommentRequestDto;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String content;
    @JoinColumn(name = "postId", nullable = false)
    @ManyToOne
    @JsonIgnore
    public Post post;

    public Comment() {
    }
    //순서 중요
    public Comment(Post post ,String content) {
        this.post = post;
        this.content = content;

    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void updateComment(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}
