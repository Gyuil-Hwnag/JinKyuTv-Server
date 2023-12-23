package com.example.demo.src.video.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchVideoReq {
    @JsonProperty("videoIdx") private int videoIdx;
    @JsonProperty("videoName") private String videoName;
    @JsonProperty("videoUrl") private String videoUrl;
}