package com.evidence.rasa.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

@ConfigurationProperties(prefix = "spring.rasa")
public class RasaProperties {

    private List<RasaInstance> instance;

    public List<RasaInstance> getInstance() {
        return instance;
    }

    public void setInstance(List<RasaInstance> instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "RasaProperties{" +
                "instance=" + instance.toString() +
                '}';
    }

    public static class RasaInstance {

        private String host;

        private String port;

        private String name;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "RasaInstance{" +
                    "host='" + host + '\'' +
                    ", port='" + port + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
