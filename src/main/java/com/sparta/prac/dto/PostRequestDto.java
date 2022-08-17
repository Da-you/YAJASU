package com.sparta.prac.dto;

// 유저의 문의? 요청을 담아주는 주머니
public class PostRequestDto {
    private String author;
    private String title;
    private String content;
    private String password;


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }


}
