package com.evidence.rasa.service;

import com.evidence.rasa.exception.NLUException;
import com.evidence.rasa.service.dto.RasaRequestDTO;
import com.evidence.rasa.service.dto.RasaResponseDTO;

public interface RasaService {

    /**
     * Post request message to Rasa Server
     * @param rasaRequestDTO
     * @return
     */
    RasaResponseDTO[] detectIntent(RasaRequestDTO rasaRequestDTO) throws NLUException;
}
