package com.parametricparts.restevo;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores the various strategies available.
 */
public class StrategyRegistry {

    public StrategyRegistry(){

    }

    public void addStrategy(String name, Class<? extends UpdateStrategy> strategyClass){
        strategies.put(name,strategyClass);
    }

    public UpdateStrategy getStrategyFor(String name){
        Class<? extends UpdateStrategy> c = getStrategyClassFor(name);
        try {
            return c.newInstance();
        }
        catch ( Exception e){
            throw new RuntimeException(e);
        }
    }

    public Class<? extends UpdateStrategy> getStrategyClassFor(String name){
        Class<? extends UpdateStrategy> c = strategies.get(name);
        if ( c == null ){
            throw new ValueException("No Strategy loaded for '" + name + "'");
        }
        return c;
    }

    private Map<String,Class<? extends UpdateStrategy>> strategies = new HashMap<String,Class<? extends UpdateStrategy>>();
}
