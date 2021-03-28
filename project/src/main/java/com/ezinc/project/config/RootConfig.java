package com.ezinc.project.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


//DI
@Configuration
@ComponentScan(basePackages = {"com.ezinc.project"})
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
}
