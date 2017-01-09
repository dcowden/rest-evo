package com.parametricparts.restevo;

import org.apache.http.client.fluent.Executor;

import java.util.Map;

/**
 * Updates a remote resource.
 * The logic that can be used to do this can be pretty complex
 */
public interface UpdateStrategy {

    void performUpdate ( SyncTask task , SyncContext context);

}
