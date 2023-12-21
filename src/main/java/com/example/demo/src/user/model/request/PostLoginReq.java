package com.example.demo.src.user.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLoginReq {
    @JsonProperty("id") private String id;
    @JsonProperty("password") private String password;
}
