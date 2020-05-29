package com.evidence.rasa.service.impl;

import com.evidence.rasa.configuration.RasaProperties;
import com.evidence.rasa.exception.NLUException;
import com.evidence.rasa.service.RasaService;
import com.evidence.rasa.service.dto.RasaRequestDTO;
import com.evidence.rasa.service.dto.RasaResponseDTO;
import com.evidence.rasa.service.util.RasaEndpoint;
import com.evidence.rasa.service.util.RasaUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RasaServiceImpl implements RasaService {

    private final RestTemplate restTemplate;

    private RasaProperties rasaProperties;

    public RasaServiceImpl(RestTemplate restTemplate, RasaProperties rasaProperties) {
        this.restTemplate = restTemplate;
        this.rasaProperties = rasaProperties;
    }

    /**
     * Post request message to Rasa Server
     *
     * @param rasaRequestDTO
     * @param instanceName
     * @return
     */
    @Override
    public RasaResponseDTO[] detectIntent(String instanceName, RasaRequestDTO rasaRequestDTO) throws NLUException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RasaRequestDTO> entity = new HttpEntity<>(rasaRequestDTO, headers);
            RasaProperties.RasaInstance rasaInstance = getRasaInstance(instanceName);
            RasaResponseDTO[] rasaResponseDTO = restTemplate.postForObject(
                    RasaUtil.constructEndpoint(rasaInstance.getHost() + ':' + rasaInstance.getPort(), RasaEndpoint.WEBHOOK),
                    entity,
                    RasaResponseDTO[].class);
            return rasaResponseDTO;
        } catch (Exception e) {
            throw new NLUException(e.getMessage(), e.getCause());
        }
    }

    private RasaProperties.RasaInstance getRasaInstance(String name){
        return (RasaProperties.RasaInstance) this.rasaProperties
                .getRasaInstance()
                .stream()
                .filter(rasaInstance -> rasaInstance.getName().equals(name))
                .toArray()[0];
    }
}
