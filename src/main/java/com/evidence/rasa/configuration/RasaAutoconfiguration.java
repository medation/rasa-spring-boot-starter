package com.evidence.rasa.configuration;

import com.evidence.rasa.annotation.EnableRasaConfiguration;
import com.evidence.rasa.service.RasaService;
import com.evidence.rasa.service.impl.RasaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnClass(RasaService.class)
@ConditionalOnBean(annotation = EnableRasaConfiguration.class)
@EnableConfigurationProperties(RasaProperties.class)
public class RasaAutoconfiguration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RasaProperties rasaProperties;

    private Logger log = LoggerFactory.getLogger(RasaAutoconfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public RasaService rasaService(){
        log.debug("Instantiation of Rasa service with configuration " + rasaProperties.toString());
        return new RasaServiceImpl(restTemplate, rasaProperties);
    }
}
