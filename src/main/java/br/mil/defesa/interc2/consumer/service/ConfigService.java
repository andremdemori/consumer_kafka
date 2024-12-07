package br.mil.defesa.interc2.consumer.service;

import br.mil.defesa.interc2.consumer.ConsumerApplication;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    public void restartSpringContext() {
        ConsumerApplication.restart();
    }
}