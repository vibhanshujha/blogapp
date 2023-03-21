package com.themechguy.blogapp.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    
}
