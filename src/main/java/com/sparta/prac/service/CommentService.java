package com.sparta.prac.service;

import com.sparta.prac.domain.Comment;
import com.sparta.prac.domain.Post;
import com.sparta.prac.dto.CommentRequestDto;
import com.sparta.prac.dto.CommentResponseDto;
import com.sparta.prac.repository.CommentRepository;
import com.sparta.prac.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public CommentResponseDto addComment(CommentRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getPostId()).get();
//        String content = requestDto.getContent();
//        Long postId = post.getId();
//        Comment comment = new Comment(post, content);
        Comment comment = new Comment(post, requestDto.getContent());
        Comment comments = commentRepository.save(comment);
        return new CommentResponseDto(comments);
    }

    public List<CommentResponseDto> readCommentList(Long id) {
        Post post = postRepository.findById(id).get();
        List<Comment> commentAll = commentRepository.findAllByPost(post);
        List<CommentResponseDto> commentList = new ArrayList<>();

        for(int i = 0; i<commentAll.size(); i++){
            Comment comment = commentAll.get(i);
            CommentResponseDto responseDto = new CommentResponseDto(comment);
            commentList.add(responseDto);
        }
        return commentList;
    }
    @Transactional
    public String updateComment(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 댓글 입니다.")
        );
        comment.updateComment(requestDto);
        return "수정 완료";
    }

    public String deleteComment(Long id){
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 댓글 입니다.")
        );
        commentRepository.delete(comment);
        return "삭제 완료";
    }
}
