package com.live.kafka.consumer.service;

import com.live.kafka.consumer.ConsumerApplication;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    public void restartSpringContext() {
        ConsumerApplication.restart();
    }
}