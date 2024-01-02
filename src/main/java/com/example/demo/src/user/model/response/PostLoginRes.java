package com.example.demo.src.user.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PostLoginRes {
    private int userIdx;
    private String jwt;
    private String userName;
}
