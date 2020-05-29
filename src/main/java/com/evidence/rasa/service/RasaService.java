package com.evidence.rasa.service;

import com.evidence.rasa.exception.NLUException;
import com.evidence.rasa.service.dto.RasaRequestDTO;
import com.evidence.rasa.service.dto.RasaResponseDTO;
import com.evidence.rasa.service.dto.RasaStatusDTO;

public interface RasaService {

    /**
     * Post request message to Rasa Server
     * @param rasaRequestDTO
     * @param instanceName
     * @return
     * @throws NLUException
     */
    RasaResponseDTO[] detectIntent(String instanceName, RasaRequestDTO rasaRequestDTO) throws NLUException;

    /**
     * Get status of Rasa instance
     * @param instanceName
     * @return
     * @throws NLUException
     */
    RasaStatusDTO checkStatus(String instanceName) throws NLUException;;
}
