package com.parametricparts.restevo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dave on 1/7/17.
 */
public class SyncTaskParser {

    public static final Logger log = LoggerFactory.getLogger(SyncTaskParser.class);

    public SyncTaskParser(){

    }

    public SyncTasks loadFromString(String json){
        return loadFromReader( new StringReader(json));
    }

    public SyncTasks loadFromResource(String location){
        ClassLoader classLoader = getClass().getClassLoader();

        Reader r = new InputStreamReader(classLoader.getResourceAsStream(location), Charset.forName("UTF-8"));
        return loadFromReader(r);
    }

    public SyncTasks loadFromReader(Reader r){
        Gson g = buildGson();
        SyncTasks st = new SyncTasks();

        JsonStreamParser jsp = new JsonStreamParser(r);
        while ( jsp.hasNext()) {
            JsonElement je = jsp.next();

            //first parse as a map
            Type type = new TypeToken<Map<String, Object>>(){}.getType();

            Map<String,Object> extraProperties = g.fromJson(je, type );

            //also parse onto a task object
            SyncTask t = g.fromJson(je,SyncTask.class);

            //copy extended properties.
            t.setExtraProperties(extraProperties);
            st.getTasks().add(t);

        }
        return st;
    }

    protected Gson buildGson(){
        return new GsonBuilder().serializeNulls().create();
    }


}
