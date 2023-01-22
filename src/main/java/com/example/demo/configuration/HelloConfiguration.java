package com.example.demo.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class HelloConfiguration {
    @Autowired
    private OracleDbProperties oracleDbProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@" + oracleDbProperties.getHost() + ":" + oracleDbProperties.getPort() + ":" + oracleDbProperties.getSid());
        dataSource.setUsername(oracleDbProperties.getUsername());
        dataSource.setPassword(oracleDbProperties.getPassword());
        
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
