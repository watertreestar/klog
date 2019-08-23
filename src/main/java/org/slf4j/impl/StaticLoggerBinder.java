package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * @Date 2019/8/22 16:37
 **/
public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static StaticLoggerBinder INSTANCE = new StaticLoggerBinder();

    public static final StaticLoggerBinder getSingleton() {
        return INSTANCE;
    }

    public StaticLoggerBinder(){
        this.loggerFactory = new KLoggerFactory();
        this.loggerFactoryStr = loggerFactory.getClass().getName();
    }


    private ILoggerFactory loggerFactory;
    private String loggerFactoryStr;

    /**
     * 供slf4j调用，返回一个ILoggerFactory类型
     * return a singleton LoggerFactory object
     * 采用饿汉式实例化ILoggerFactory对象
     * @return
     */
    @Override
    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return null;
    }
}
