package com.live.kafka.consumer.DTO;

import lombok.Data;

@Data
public class AccessTokenRequestDTO {
    private String clientId;
    private String username;
    private String password;
    private String grantType;
    private String clientSecret;

}
