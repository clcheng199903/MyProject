package com.example.mybatisdemospringmutildatasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * 主数据源
 *
 * 1.对应实体类配置，用于识别实体类别名，可能是指定mapper.xml中的resultType或parameterType的实体类别名，这样才能主动找到这些类
 * 2.对应的mapper.xml文件路径
 * 3.显式的Mapper.java类扫描配置，@MapperScan
 */
@Configuration
@MapperScan(basePackages = "com.example.mybatisdemospringmutildatasource.mapper.sqlserver", sqlSessionFactoryRef = "sqlserverSqlSessionFactory")
public class HikariSqlServerConfig {
    /**
     * @ConfigurationProperties 读取yml中的配置参数映射成一个对象，并传给new HikariDataSource()做数据源
     */
    @Bean(name = "sqlserverDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
    public HikariDataSource sqlserverDataSource() {
        return new HikariDataSource();
    }

    /**
     * mybatis-config.xml也是为配置sqlsession的，这里使用代码方式进行配置;
     * 1.mapper.xml路径配置——MapperLocation
     * 2.mapper.xml的ReturnType和ParameterType的类型basePackage配置——TypeAliasesPackage
     * @param dataSource
     * @return
     */
    // bean也会初始化，所以也有参数注入的过程，通过@Qualifier指定bean类型
    @Bean(name = "sqlserverSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlserverSqlSessionFactory(@Qualifier("sqlserverDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        // configuration配置
        bean.setConfiguration(configuration);

        // 单路径扫描
        // mybatis扫描mapper.xml所在位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/sqlserver/*.xml"));
        bean.setTypeAliasesPackage("com.example.mybatisdemospringmutildatasource.domain");
        return bean.getObject();
    }

    /**
     * SqlSessionFactory用于创建SqlSession
     * SqlSessionTemplate是具体的SqlSession（配置），比如JdbcTemplate
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean("sqlserverSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlserverSqlSessionTemplate(@Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 配置事务管理
     * @return
     */
    //不配值这个bean，@Transaction注解可能失效
    //使用时 @Transactional(value = "sqlserverTransactionManager",rollbackFor = {Exception.class, RuntimeException.class})
    @Bean("sqlserverTransactionManager")
    public TransactionManager sqlserverTransactionManager() {
        return new JdbcTransactionManager(sqlserverDataSource());
    }

}
