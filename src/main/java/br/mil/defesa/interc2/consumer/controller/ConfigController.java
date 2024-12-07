package br.mil.defesa.interc2.consumer.controller;

import br.mil.defesa.interc2.consumer.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @CrossOrigin("*")
    @PostMapping("/restart")
    public void restart() {
        configService.restartSpringContext();
    }
}
