package com.evidence.rasa.service.util;

public class RasaUtil {

    public static final String constructEndpoint(String url, RasaEndpoint rasaEndpoint, String ...params){
        switch (rasaEndpoint) {
            case WEBHOOK:
                return url + Constant.WEBHOOK_ENDPOINT;
            case CONVERSATION_TRACKER:
                return url + String.format(Constant.CONVERSATION_TRACKER_ENDPOINT, params[0]);
            default:
                return "";
        }
    }
}
