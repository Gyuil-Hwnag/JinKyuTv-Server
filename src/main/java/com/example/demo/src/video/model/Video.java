package com.example.demo.src.video.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Video {
    private int videoIdx;
    private String videoName;
    private String videoUrl;
}
