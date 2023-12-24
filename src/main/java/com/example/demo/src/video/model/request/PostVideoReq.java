package com.example.demo.src.video.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostVideoReq {
    @JsonProperty("videoName") private String videoName;
    @JsonProperty("videoUrl") private String videoUrl;
    @JsonProperty("videoThumbnail") private String videoThumbnail;
}
