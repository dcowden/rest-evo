package com.parametricparts.restevo;

import org.apache.http.client.fluent.Executor;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the Results of a set of Sync Tasks
 */
public class SyncContext {


    public SyncContext(ServerSettings settings){

        Executor ex = Executor.newInstance();

        //transfer settings into the executor

    }

    public void addTaskResult(SyncTask task, boolean result, String message){
        results.add ( new SyncResult(task.getIdentifier(),result,message));
    }

    public Executor getExecutor(){
        return this.executor;
    }


    public List<SyncResult> getResults(){
        return this.results;
    }

    private Executor executor;
    private ServerSettings settings;

    private List<SyncResult> results = new ArrayList<SyncResult>();
}

class SyncResult{

    public SyncResult(String name, boolean success, String message){
        this.name = name;
        this.success = success;
        this.message = message;
    }

    public String getName() {
        return name;
    }


    public boolean isSuccess() {
        return success;
    }


    public String getMessage() {
        return message;
    }


    private String name;
    private boolean success;
    private String message;

}
