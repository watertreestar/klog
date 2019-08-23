package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2019/8/22 17:37
 **/
public class KLoggerFactory implements ILoggerFactory {


    /**
     * logger cache
     */
    private Map<String,Logger> loggerCache = null;

    public KLoggerFactory(){
        loggerCache = new ConcurrentHashMap<>();
        KLogger.lazyInit();
    }

    /**
     * return properly logger by name
     * LoggerFactory is singleton,the method return different logger determined by different name
     * @param name
     * @return
     * TODO : thread safe need in concurrent env ? DCL? CAS ? or synchronized
     *
     */
    @Override
    public Logger getLogger(String name) {
        Logger simpleLogger = loggerCache.get(name);
        if (simpleLogger != null) {
            return simpleLogger;
        } else {
            Logger newInstance = new KLogger(name);
            Logger oldInstance = loggerCache.putIfAbsent(name, newInstance);
            return oldInstance == null ? newInstance : oldInstance;
        }
    }
}
