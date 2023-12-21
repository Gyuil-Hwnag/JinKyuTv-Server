package com.example.demo.src.user.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PatchUserReq {
    @JsonProperty("userIdx") private int userIdx;
    @JsonProperty("userName") private String userName;
}
