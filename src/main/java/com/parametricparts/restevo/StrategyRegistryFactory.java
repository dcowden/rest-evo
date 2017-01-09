package com.parametricparts.restevo;

/**
 * Created by dave on 1/8/17.
 */
public class StrategyRegistryFactory {

    private StrategyRegistryFactory(){}

    public static final String WRITE_UNCONDITIONAL = "overwrite";
    public static final String ADD_IF_MISSING = "add";
    public static final String MERGE = "merge";
    public static final String DEFAULT = ADD_IF_MISSING;

    public static StrategyRegistry getDefaultRegistry(){
        StrategyRegistry sr = new StrategyRegistry();
        sr.addStrategy(WRITE_UNCONDITIONAL, WriteUnconditionallyStrategy.class);
        sr.addStrategy(ADD_IF_MISSING, WriteIfMissingStrategy.class);
        //sr.addStrategy(MERGE, MergeUpdateStrategy.class);
        return sr;
    }

}
