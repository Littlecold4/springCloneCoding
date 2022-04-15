package com.sparta.springclonecoding.model;

import com.sparta.springclonecoding.dto.LikeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Boolean like;

    private Long userid;

    public Like(LikeDto likeDto){
        this.userid = likeDto.getUserid();
    }
}
