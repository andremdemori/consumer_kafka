package com.live.kafka.consumer.service;

import com.live.kafka.consumer.DTO.MessageDTO;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SiplomService {

    private static final Logger logger = LoggerFactory.getLogger(SiplomService.class);
    private final OkHttpClient client;

    public SiplomService() {
        this.client = new OkHttpClient().newBuilder().build();
    }

    public void sendToSiplom(MessageDTO message) {
        String token = "SEU_ACCESS_TOKEN";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\n  \"idOperacaoUsuarioSiplom4Siplom4\": \"\",\n " +
                        " \"retificado\": \"\",\n " +
                        " \"nomeOperacaoUsuarioSiplom4Siplom4\": \"\",\n " +
                        " \"siglaOperacaoUsuarioSiplom4Siplom4\": \"\",\n  " +
                        "\"codigoEpeoUsuarioOperacaoSiplom4\": \"\",\n " +
                        " \"nomeEpeoUsuarioOperacaoSiplom4\": \"\",\n  " +
                        "\"apelidoEpeoUsuarioOperacaoSiplom4\": \"\",\n " +
                        " \"idUsuarioSiplom4\": \"2411061723052910\",\n  " +
                        "\"nomeUsuarioSiplom4\": \"\",\n  " +
                        "\"idOperacao\": \"00000000-0000-0000-2410-221941000016\",\n  " +
                        "\"parentId\": \"\",\n  " +
                        "\"tipo\": \"MENSAGEM_COORDENACAO\",\n  " +
                        "\"idUsuariosDestino\": [],\n  " +
                        "\"idUsuariosInfo\": [],\n " +
                        "\"assunto\": \"" + message.getSubject() + "\",\n" +
                        "\"texto\": \"" + message.getPayload() + "\"\n");

        Request request = new Request.Builder()
                .url("https://siplom-azuver.defesa.mil.br/api/siplom-docope/operacao/00000000-0000-0000-2410-221941000016/documentos/ext")
                .method("POST", body)
                .addHeader("Content-Type", "application/json") //"Authorization", "Bearer " + token
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                logger.info("Message successfully sent to SIPLOM: " + response.body().string());
            } else {
                logger.error("Failed to send message to SIPLOM. Response code: " + response.code() +
                        ", Response body: " + response.body().string());
            }
        } catch (IOException e) {
            logger.error("Error sending message to SIPLOM API: ", e);
        }
    }
}
