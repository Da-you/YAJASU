package com.sparta.prac.controller;

import com.sparta.prac.dto.CreatPostResponseDto;
import com.sparta.prac.dto.PostRequestDto;
import com.sparta.prac.dto.PostResponseDto;
import com.sparta.prac.dto.PostsResponseDto;
import com.sparta.prac.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Json응답을 위해 사용
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/post") //리퀘스트 바디로 DTO에 있는 정보입력값을 받는다.
    public CreatPostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        if (requestDto.getTitle() == "" || requestDto.getContent() == "") {
            throw new IllegalArgumentException("1자 이상의 글을 적어주세요");
        }
        return postService.createPost(requestDto);
    }

    //레포지토리에서 저장된 포스트리스트를 조회 한다.
    @GetMapping("/api/post")
    public List<PostsResponseDto> viewPost() {
        return postService.viewPost();
    }

    //특정게시글 조회
    @GetMapping("/api/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    //패스워드 확인
    @PostMapping("/api/post/{id}")
    public String checkPassword(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.checkPassword(id, requestDto);
    }

    //게시글 수정
    @PutMapping("/api/post/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }


    //게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.deletePost(id, requestDto);

    }
}
