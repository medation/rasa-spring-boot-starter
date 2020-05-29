package com.evidence.rasa.configuration;

import java.util.List;

public class RasaProperties {

    private List<RasaInstance> rasaInstance;

    public List<RasaInstance> getRasaInstance() {
        return rasaInstance;
    }

    public void setRasaInstance(List<RasaInstance> rasaInstance) {
        this.rasaInstance = rasaInstance;
    }

    @Override
    public String toString() {
        return "RasaProperties{" +
                "rasaInstance=" + rasaInstance.toString() +
                '}';
    }

    public class RasaInstance {

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
