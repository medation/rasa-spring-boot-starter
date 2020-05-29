package com.evidence.rasa.service.impl;

import com.evidence.rasa.configuration.RasaProperties;
import com.evidence.rasa.exception.NLUException;
import com.evidence.rasa.service.RasaService;
import com.evidence.rasa.service.dto.RasaRequestDTO;
import com.evidence.rasa.service.dto.RasaResponseDTO;
import com.evidence.rasa.service.dto.RasaStatusDTO;
import com.evidence.rasa.service.util.RasaEndpoint;
import com.evidence.rasa.service.util.RasaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RasaServiceImpl implements RasaService {

    private final RestTemplate restTemplate;

    private RasaProperties rasaProperties;

    private Logger log = LoggerFactory.getLogger(RasaServiceImpl.class);

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
     * @throws NLUException
     */
    @Override
    public RasaResponseDTO[] detectIntent(String instanceName, RasaRequestDTO rasaRequestDTO) throws NLUException {
        log.debug("Calling service Rasa for detection of intent");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<RasaRequestDTO> entity = new HttpEntity<>(rasaRequestDTO, headers);
            RasaProperties.RasaInstance rasaInstance = getRasaInstance(instanceName);
            ResponseEntity<RasaResponseDTO[]> responseEntity = restTemplate.postForEntity(
                    RasaUtil.constructEndpoint(rasaInstance.getHost() + ':' + rasaInstance.getPort(), RasaEndpoint.WEBHOOK),
                    entity,
                    RasaResponseDTO[].class);
            if(responseEntity.getStatusCode().is2xxSuccessful())
                return responseEntity.getBody();
            else
                throw new NLUException("Error while sending message to Rasa with status code : " + responseEntity.getStatusCode());
        } catch (Exception e) {
            throw new NLUException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Get status of Rasa instance
     * @param instanceName
     * @return
     * @throws NLUException
     */
    @Override
    public RasaStatusDTO checkStatus(String instanceName) throws NLUException {
        log.debug("Calling service Rasa for checking status of instance");
        try {
            RasaProperties.RasaInstance rasaInstance = getRasaInstance(instanceName);
            ResponseEntity<RasaStatusDTO> responseEntity = restTemplate.getForEntity(
                    RasaUtil.constructEndpoint(rasaInstance.getHost() + ':' + rasaInstance.getPort(), RasaEndpoint.STATUS),
                    RasaStatusDTO.class);
            if(responseEntity.getStatusCode().is2xxSuccessful())
                return responseEntity.getBody();
            else
                throw new NLUException("Error while check status of Rasa with status code : " + responseEntity.getStatusCode());
        } catch (Exception e) {
            throw new NLUException(e.getMessage(), e.getCause());
        }
    }

    private RasaProperties.RasaInstance getRasaInstance(String name) {
        return (RasaProperties.RasaInstance) this.rasaProperties
                .getRasaInstance()
                .stream()
                .filter(rasaInstance -> rasaInstance.getName().equals(name))
                .toArray()[0];
    }
}
