package com.evidence.rasa.service.dto;

import java.io.Serializable;
import java.util.Arrays;

public class RasaFingerprintDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] config;

    private String[] domain;

    private String[] messages;

    private String[] stories;

    private float trained_at;

    private String[] version;

    public String[] getConfig() {
        return config;
    }

    public void setConfig(String[] config) {
        this.config = config;
    }

    public String[] getDomain() {
        return domain;
    }

    public void setDomain(String[] domain) {
        this.domain = domain;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }

    public String[] getStories() {
        return stories;
    }

    public void setStories(String[] stories) {
        this.stories = stories;
    }

    public float getTrained_at() {
        return trained_at;
    }

    public void setTrained_at(float trained_at) {
        this.trained_at = trained_at;
    }

    public String[] getVersion() {
        return version;
    }

    public void setVersion(String[] version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RasaFingerprintDTO{" +
                "config=" + Arrays.toString(config) +
                ", domain=" + Arrays.toString(domain) +
                ", messages=" + Arrays.toString(messages) +
                ", stories=" + Arrays.toString(stories) +
                ", trained_at=" + trained_at +
                ", version=" + Arrays.toString(version) +
                '}';
    }
}
