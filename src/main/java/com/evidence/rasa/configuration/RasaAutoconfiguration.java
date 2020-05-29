package com.evidence.rasa.configuration;

import com.evidence.rasa.service.RasaService;
import com.evidence.rasa.service.impl.RasaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnClass(RasaService.class)
public class RasaAutoconfiguration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RasaProperties rasaProperties;


    @Bean
    @ConditionalOnMissingBean
    public RasaService rasaService(){
        return new RasaServiceImpl(restTemplate, rasaProperties);
    }
}
