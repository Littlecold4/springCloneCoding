package com.sparta.springclonecoding.controller;

import com.sparta.springclonecoding.dto.*;
import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.security.UserDetailsImpl;
import com.sparta.springclonecoding.service.PostService;
import com.sparta.springclonecoding.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    
    // 게시글 작성
    @PostMapping("/api/posts")
    public PostResponseDto savePost (@RequestParam(value = "multipartFile") MultipartFile multipartFile, @RequestParam("content") String content, @AuthenticationPrincipal UserDetailsImpl userDetails) throws Exception {
        return postService.postPost(multipartFile, content, userDetails);
    }

    // 게시글 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> showPost(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.getPost(userDetails);
    }
    
    // 게시글 수정
    @PutMapping("/api/posts/{postId}")
    public PostResponseDto updatePost (@PathVariable Long postId, @RequestParam("multipartFile") MultipartFile multipartFile, @RequestParam("content") String content ) throws IOException {
        return postService.putPost(postId, multipartFile, content);
    }
    
    // 게시글 삭제
    @DeleteMapping("/api/posts/{postId}")
    public Long deletePost (@PathVariable Long postId) {
        return postService.delPost(postId);
    }

    // 프로필 보기
    @GetMapping("/api/posts/mypost")
    public ProfileDto showProfile(@AuthenticationPrincipal UserDetailsImpl userDetails){
       return postService.showProfile(userDetails);
    }
      
    // 상세페이지
    @GetMapping("/api/detail/{postid}")
    public DetailDto showDetail(@PathVariable Long postid,
                                @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.showDetail(postid,userDetails);
    }
}
