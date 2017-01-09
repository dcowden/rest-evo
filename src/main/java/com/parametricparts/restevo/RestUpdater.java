package com.parametricparts.restevo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.io.IOException;

/**
 * Created by dave on 1/8/17.
 */
public class RestUpdater {

    public static final Logger log = LoggerFactory.getLogger(RestUpdater.class);
    public RestUpdater(){

    }

    public String toJson(Object obj){
        Gson g = new GsonBuilder().create();
        String content = g.toJson(obj);
        return content;
    }

    public GetResponse getContent(String url, Executor executor){
        GetResponse cr = new GetResponse();

        try{
            HttpResponse response = executor.execute(Request.Get(url)).returnResponse();
            cr.setStatusCode(response.getStatusLine().getStatusCode());
            cr.setContent(getResponseContentAsString(response.getEntity()));
        }
        catch(IOException ioe){
            log.warn("Cannot read url " + url);
        }
        return cr;

    }

    public WriteResponse writeContent(String url, String bodyData, Executor executor){
        WriteResponse wr = new WriteResponse();
        try{
            HttpResponse response = executor.execute(Request.Post(url).bodyString(bodyData,ContentType.APPLICATION_JSON)).returnResponse();

            if ( response.getStatusLine().getStatusCode() < 500){
                wr.setSuccess(true);
            }
            else{
                wr.setSuccess(false);
            }

        }
        catch(IOException ioe){
            log.warn("Cannot write to  url " + url);
            wr.setSuccess(false);
        }
        return wr;
    }

    protected String getResponseContentAsString(HttpEntity entity){
        ContentType contentType = ContentType.getOrDefault(entity);
        try{
            return IOUtils.toString(entity.getContent(),contentType.getCharset().name());
        }
        catch ( IOException ioe){
            throw new RuntimeException(ioe);
        }
    }
}


class WriteResponse {


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success;

}
class GetResponse {

    public boolean hasContent(){
        return statusCode > 199 && statusCode < 300;
    }
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private int statusCode = 0;
    private String content;

}