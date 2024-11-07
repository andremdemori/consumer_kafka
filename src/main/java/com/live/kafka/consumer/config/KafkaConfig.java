package com.live.kafka.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@RefreshScope
@Configuration
@PropertySource({"file:config/kafka.properties"})
public class KafkaConfig {

    @Value("${topic.name}")
    private String topicName;

    @Value("${spring.kafka.bootstrap-servers}")
    private String springKafkaBootstrapServers;

    @Value("${spring.kafka.group-id}")
    private String springKafkaGroupId;

    public String getTopicName() {
        return topicName;
    }

    public String getSpringKafkaBootstrapServers() {
        return springKafkaBootstrapServers;
    }

    public String getSpringKafkaGroupId() {
        return springKafkaGroupId;
    }

}