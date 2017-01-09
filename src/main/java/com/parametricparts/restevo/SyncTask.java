package com.parametricparts.restevo;

import java.util.Map;

/**
 * A sync task.
 * Extra properties are those not built-in, so that other strategy implementations
 * can accept properties on the task if needed
 */
public class SyncTask {


    public String getWriteUrl() {
        return writeUrl;
    }

    public void setWriteUrl(String writeUrl) {
        this.writeUrl = writeUrl;
    }

    public String getReadUrl() {
        if ( readUrl ==  null){
            return getWriteUrl();
        }
        else{
            return readUrl;
        }

    }

    public String getIdentifier(){
        if ( this.name != null ){
            return getName();
        }
        else{
            if ( this.description != null ){
                return getDescription();
            }
        }
        return "Anonymous at :<" + this.writeUrl + ">";
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getExtraProperties() {
        return extraProperties;
    }

    public void setExtraProperties(Map<String, Object> extraProperties) {
        this.extraProperties = extraProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String writeUrl;
    private String readUrl;
    private String strategy = StrategyRegistryFactory.DEFAULT;
    private Map<String,Object> data;
    private String description;
    private Map<String,Object> extraProperties;

}
