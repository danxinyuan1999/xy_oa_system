package com.dan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis 配置类
 *
 * @author dan
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.dan.mapper"})
public class MybatisConfig {
}
