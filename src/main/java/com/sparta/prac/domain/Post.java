package com.sparta.prac.domain;

import com.sparta.prac.dto.PostRequestDto;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Setter
@Entity
public class Post extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "post")
    private List<Comment> commentList;

    //기본 생성자

    public Post() {
    }

    //생성자
    public Post(String title, String author, String content, String password) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.password = password;
    }

    //Getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public Post(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Post(PostRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();

    }

    //함수
    public void updatePost(PostRequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
    }


}
