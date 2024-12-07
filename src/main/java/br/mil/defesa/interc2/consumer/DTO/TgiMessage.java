package br.mil.defesa.interc2.consumer.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TgiMessage(@JsonProperty("uniqueID") String uniqueID, @JsonProperty("subject") String subject,
                         @JsonProperty("payload") String payload) {
}
