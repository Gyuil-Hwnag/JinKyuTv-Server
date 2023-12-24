package com.example.demo.src.video.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetVideoRes {
    @JsonProperty("videoIdx") private int videoIdx;
    @JsonProperty("videoName") private String videoName;
    @JsonProperty("videoUrl") private String videoUrl;
    @JsonProperty("videoThumbnail") private String videoThumbnail;
}
