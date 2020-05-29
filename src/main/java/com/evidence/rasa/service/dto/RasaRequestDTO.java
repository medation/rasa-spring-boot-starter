package com.evidence.rasa.service.dto;

import java.io.Serializable;

public class RasaRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sender;

    private String message;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RasaRequestDTO{" +
                "sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
