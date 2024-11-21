package com.live.kafka.consumer.consumer;

import com.live.kafka.consumer.DTO.MessageDTO;
import com.live.kafka.consumer.config.KafkaConfig;
import com.live.kafka.consumer.service.SiplomService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class messageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(messageConsumer.class);
    private final KafkaConfig kafkaConfig;
    private final SiplomService siplomService;

    public messageConsumer(KafkaConfig kafkaConfig, SiplomService siplomService) {
        this.kafkaConfig = kafkaConfig;
        this.siplomService = siplomService;
    }

    @KafkaListener(topics = "#{kafkaConfig.topicName}",
                   groupId = "#{kafkaConfig.springKafkaGroupId}",
                   containerFactory = "messageKafkaListenerContainerFactory"
                  )
    public void listenTopicMessage(ConsumerRecord<String, MessageDTO> record) {
        logger.info("Received Message in partition " + record.partition());
        logger.info("Received Message: " + record.value());

        MessageDTO message = record.value();
        try {
            siplomService.sendToSiplom(message);
        } catch (Exception e) {
            logger.error("Error processing message: ", e);
        }
    }
}
