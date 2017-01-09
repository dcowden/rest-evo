package com.parametricparts.restevo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs each task by selecting the best strategy
 */
public class SyncRunner {

    public static final Logger log = LoggerFactory.getLogger(SyncRunner.class);


    public void run( SyncContext context, SyncTasks tasks){
        for ( SyncTask task: tasks.getTasks()){

        }
    }
}
