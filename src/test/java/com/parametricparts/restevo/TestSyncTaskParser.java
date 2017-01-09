package com.parametricparts.restevo;

import com.google.gson.GsonBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dave on 1/7/17.
 */
public class TestSyncTaskParser {



    @Test
    public void testBasic(){
        SyncTaskParser alp = new SyncTaskParser();


        SyncTasks tasks = alp.loadFromResource("basicTest.json");

        assertEquals(2, tasks.getTasks().size());

        SyncTask st1 = tasks.getTasks().get(0);
        assertEquals( "https://label-svc.colinxdev.com/v1/label-svc/strategies", st1.getReadUrl());
        assertEquals( "EXTRA_PROPERTY_VALUE",st1.getExtraProperties().get("EXTRA_PROPERTY_NAME") );
        assertEquals( st1.getStrategy(), StrategyRegistryFactory.MERGE);

        SyncTask st2 = tasks.getTasks().get(1);
        assertEquals( "https://label-svc.colinxdev.com/v1/label-svc/strategies2", st2.getReadUrl());
        assertEquals( st2.getStrategy(), StrategyRegistryFactory.DEFAULT);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(st2.getData()) );

    }

}
