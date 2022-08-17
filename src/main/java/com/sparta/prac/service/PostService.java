package com.sparta.prac.service;

import com.sparta.prac.domain.Comment;
import com.sparta.prac.dto.CommentResponseDto;
import com.sparta.prac.repository.CommentRepository;
import com.sparta.prac.repository.PostRepository;
import com.sparta.prac.domain.Post;
import com.sparta.prac.dto.PostRequestDto;
import com.sparta.prac.dto.PostResponseDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    private final CommentService commentService;

    public PostService(PostRepository postRepository, CommentRepository commentRepository, CommentService commentService) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }


    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        Post post1 = postRepository.save(post);
        return new PostResponseDto(post1);
    }

    //전체 게시글 조회
    public List<PostResponseDto> viewPost() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponseDto> responseDtos = new ArrayList<>();

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            PostResponseDto responseDto = new PostResponseDto(post);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    //특정게시글 조회
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        List<Comment> commentAll = commentRepository.findAllByPost(post);
        List<CommentResponseDto> commentList = new ArrayList<>();

        for (int i = 0; i < commentAll.size(); i++) {
            Comment comment = commentAll.get(i);
            CommentResponseDto responseDto = new CommentResponseDto(comment);
            commentList.add(responseDto);
        }
        return new PostResponseDto(post);
    }

    //비밀 번호 확인
    public String checkPassword(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재 하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            return requestDto.getPassword();
        } else {
            return "틀린 번호입니다.";
        }
    }

    @Transactional
    public String updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디 입니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            post.updatePost(requestDto);
            return "수정 완료";
        } else {
            return "비밀 번호를 확인해 주세요";
        }
    }

    @Transactional
    public String deletePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글 입니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.delete(post);
            return "삭제 완료";
        } else {
            return "비밀 번호를 확인해 주세요";
        }
    }
}

