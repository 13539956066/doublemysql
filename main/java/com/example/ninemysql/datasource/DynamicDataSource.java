package com.example.ninemysql.datasource;/*
 * Created by ZHANG on 2018/8/1
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.debug("数据源为===>{}", DatabaseContextHolder.getDatabaseType());
        return DatabaseContextHolder.getDatabaseType();
    }
}
