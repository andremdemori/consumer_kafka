package com.live.kafka.consumer.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTO {

    private String id;
    private String mensagem;
}