package com.sparta.springclonecoding.dto;

import com.sparta.springclonecoding.model.Post;
import com.sparta.springclonecoding.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ProfileDto {
    String nickname;
    String progfileImg;
    int postCnt;
    List<Post> post;

    public ProfileDto(User user, int postCnt){
        this.nickname = user.getNickname();
        this.progfileImg = user.getProfile();
        this.post = user.getPosts();
        this.postCnt = postCnt;
    }
}
