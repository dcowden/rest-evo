package com.parametricparts.restevo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 1/7/17.
 */
public class SyncTasks {

    public SyncTasks(){

    }

    public SyncTasks(SyncTasks otherTasks){
        this.tasks.addAll(otherTasks.getTasks());
    }

    private List<SyncTask> tasks = new ArrayList<SyncTask>();

    public List<SyncTask> getTasks() {
        return tasks;
    }
}
