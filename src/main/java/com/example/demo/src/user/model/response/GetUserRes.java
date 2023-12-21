package com.example.demo.src.user.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    @JsonProperty("userIdx") private int userIdx;
    @JsonProperty("userName") private String userName;
    @JsonProperty("id") private String ID;
    @JsonProperty("email") private String email;
    @JsonProperty("password") private String password;
}
