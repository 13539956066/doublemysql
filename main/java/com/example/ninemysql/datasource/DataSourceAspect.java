package com.example.ninemysql.datasource;/*
 * Created by ZHANG on 2018/8/2
 */

import com.example.ninemysql.dao.StudentDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("execution(* com.example.ninemysql.dao.*.*(..))")
    public void JoinPoint(){
    }

    //使用定义切点表达式的方法进行点表达式的引入
    @Before("JoinPoint()")
    public void setDataSourceKey(JoinPoint point){
        //如果连接点所属的类实例是StudentDao
        if(point.getTarget() instanceof StudentDao){
            DatabaseContextHolder.setDatabaseType(DatabaseType.lxy2018);
        }else{//连接点是UserDao,可以不写是默认的数据源
            DatabaseContextHolder.setDatabaseType(DatabaseType.test);
        }
    }
}
