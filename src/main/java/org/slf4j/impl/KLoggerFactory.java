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
     * shared resource in concurrent env
     */
    private Map<String,Logger> loggerCache = new ConcurrentHashMap<String,Logger>();

    /**
     * 返回真实的Logger
     * LoggerFactory is singleton,the method return different logger determined by different name
     * @param name
     * @return
     * TODO : thread safe in concurrent env
     *
     */
    @Override
    public Logger getLogger(String name) {
        Logger logger = loggerCache.get(name);
        if(logger == null){
            logger = new KLogger(name);
            loggerCache.put(name, logger);
        }
        return logger;
    }
}
