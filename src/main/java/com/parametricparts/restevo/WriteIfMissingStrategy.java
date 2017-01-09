package com.parametricparts.restevo;

import org.apache.http.client.fluent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Updates the resource only if it is missing from the server
 */
public class WriteIfMissingStrategy implements UpdateStrategy{

    public static final Logger log = LoggerFactory.getLogger(WriteIfMissingStrategy.class);
    public void performUpdate(SyncTask task, SyncContext context) {

        String readUrl = task.getReadUrl();
        String writeUrl = task.getWriteUrl();
        RestUpdater utils  = new RestUpdater();
        Executor executor = context.getExecutor();

        GetResponse response = utils.getContent(readUrl,executor);
        if ( ! response.hasContent() ){
            log.info("Content Does not Exist at" + task.getReadUrl() + ", updating at remote: " + task.getWriteUrl() );
            WriteResponse wr = utils.writeContent(writeUrl,utils.toJson(task.getData()),executor);
            if ( wr.isSuccess()){
                context.addTaskResult(task,true,"Saved To '" + writeUrl + "'");
            }
            else{
                context.addTaskResult(task,false,"Did not already exist, but could not post to '" + writeUrl + "'");
            }
        }
        else{
            context.addTaskResult(task,true,"Content Already Existed at url '" + readUrl + "'");
        }

    }



}
