package com.parametricparts.restevo;

import org.apache.http.client.fluent.Executor;

/**
 * Updates the resource regardless of what the server state is
 */
public class WriteUnconditionallyStrategy implements UpdateStrategy{
    public void performUpdate(SyncTask task, SyncContext context) {

        RestUpdater utils = new RestUpdater();
        Executor executor = context.getExecutor();
        String writeUrl = task.getWriteUrl();

        WriteResponse wr = utils.writeContent(writeUrl,utils.toJson(task.getData()), executor);
        if ( wr.isSuccess()){
            context.addTaskResult(task,true,"Saved To '" + writeUrl + "'");
        }
        else{
            context.addTaskResult(task,false,"Could not post to '" + writeUrl + "'");
        }

    }
}
