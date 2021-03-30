package com.ezinc.project.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


//DI
@Configuration
@ComponentScan(basePackages = {"com.ezinc.project"})
@MapperScan(basePackages = {"com.ezinc.project"})
public class RootConfig {

  @Bean
  public DataSource dataSource() {
      HikariConfig hikariConfig = new HikariConfig();
      hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
      hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
      hikariConfig.setUsername("kimdk");
      hikariConfig.setPassword("abcd");

      HikariDataSource dataSource = new HikariDataSource(hikariConfig);

      return dataSource;
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
	  SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	  sqlSessionFactory.setDataSource(dataSource());
	  return (SqlSessionFactory) sqlSessionFactory.getObject();
  }
}
