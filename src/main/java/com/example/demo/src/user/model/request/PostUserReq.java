package com.example.demo.src.user.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUserReq {
    @JsonProperty("userName") private String userName;
    @JsonProperty("id") private String id;
    @JsonProperty("email") private String email;
    @JsonProperty("password") private String password;
}
