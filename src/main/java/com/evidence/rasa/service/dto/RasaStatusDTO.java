package com.evidence.rasa.service.dto;

import java.io.Serializable;

public class RasaStatusDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private RasaFingerprintDTO fingerprint;

    private String model_file;

    private int num_active_training_jobs;

    @Override
    public String toString() {
        return "RasaStatusDTO{" +
                "fingerprint=" + fingerprint.toString() +
                ", model_file='" + model_file + '\'' +
                ", num_active_training_jobs=" + num_active_training_jobs +
                '}';
    }
}
