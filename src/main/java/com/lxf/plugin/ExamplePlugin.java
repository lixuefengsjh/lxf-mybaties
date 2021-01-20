package com.lxf.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

@Slf4j
@Intercepts( @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))

        public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        // SQL execute start time
        long startTimeMillis = System.currentTimeMillis();
        // get execute result
        Object proceedReslut = invocation.proceed();
        // SQL execute end time
        long endTimeMillis = System.currentTimeMillis();
        log.debug("<< ==== sql execute runnung time：{} millisecond ==== >>", (endTimeMillis - startTimeMillis));
        return proceedReslut;
    }

    public Object plugin(Object o) {
        // 调用插件
        return Plugin.wrap(o, this);

    }

    public void setProperties(Properties properties) {

    }
}
