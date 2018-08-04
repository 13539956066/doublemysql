package com.example.ninemysql.datasource;/*
 * Created by ZHANG on 2018/8/1
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//保存一个线程安全的DatabaseType容器
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();
    public static final Logger log = LoggerFactory.getLogger(DatabaseContextHolder.class);


    public static void setDatabaseType(DatabaseType type) {
        log.info("切换到{}数据源", type);
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType() {
        return (contextHolder.get());
    }
    public static void clearDatabaseType(){
        contextHolder.remove();
    }
}