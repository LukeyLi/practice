package com.lzy.design.pattern.structural.proxy.db;

/**
 * @description:
 * @author: lzy
 * @create: 2020-01-28 23:31
 **/
public class DataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

    public static void setDBType(String dbType){
        CONTEXT_HOLDER.set(dbType);
    }
    public static String getDBType(){
        return (String)CONTEXT_HOLDER.get();
    }
    public static void clearDBType(){
        CONTEXT_HOLDER.remove();
    }
}
