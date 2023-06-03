package com.example.mybatisdemo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory factory = null;
    private final static String config = "mybatis-config.xml";

    static {
        // 读取配置文件
        try {
            InputStream is = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 获取sqlsession方法
    // 执行CRUD的核心，相当于JDBC中的Connection
    public static SqlSession getSqlSession() {
        SqlSession session = null;

        if (factory != null) {
            // 此处设置为非自动提交事务
            session = factory.openSession();
        }
        String a = "${name}";
        return session;
    }
}
