package com.parametricparts.restevo;

import java.util.Map;
/**
 * Created by dave on 1/7/17.
 */
public class ServerResponse {

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseAsString() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private int responseCode;
    private String body;
}
