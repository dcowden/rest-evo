package com.parametricparts.restevo;


import java.util.Map;

public class ServerSettings {

    private ServerSettings(){}

    private Map<String,String> templateMap;
    private Map<String,String> headerMap;

    public Map<String, String> getTemplateMap() {
        return templateMap;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public class Builder{

        private final String AUTH_BASIC="Auth:Basic";
        private ServerSettings settings = new ServerSettings();


        public Builder authBasic(String username, String password){
            Map<String,String> headers = settings.getHeaderMap();
            //TODO: stash username and pass base64 encoded
            return this;
        }

        public Builder replaceTemplate(String template, String value){
            settings.getTemplateMap().put(template,value);
            return this;
        }

        public ServerSettings build(){
            return settings;
        }

    }

}
