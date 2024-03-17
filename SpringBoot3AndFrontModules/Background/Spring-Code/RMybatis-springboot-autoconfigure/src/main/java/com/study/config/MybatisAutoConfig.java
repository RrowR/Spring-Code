package com.study.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author: Rrow
 * @date: 2024/3/17 22:12
 * Description: 创建Mybatis的自动配置类
 */
@AutoConfiguration
public class MybatisAutoConfig {
    // SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {     // 这里要配置META-INF  原因是先加载了Springboot配置(包含了已经创建好的dataSource),再加载了META-INF里的自定义配置,并将dataSource传入到自定义配置里面来
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    // MapperScannerConfigurer
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(BeanFactory beanFactory) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 需要配置扫描的包路径,包含启动类的包以及子包
        List<String> packages = AutoConfigurationPackages.get(beanFactory);
        //  获取启动类的包路径
        String pg = packages.get(0);
        mapperScannerConfigurer.setBasePackage(pg);
        // 扫描注解
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        return mapperScannerConfigurer;
    }
}
