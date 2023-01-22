package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Configuration
public class OracleDbProperties {
    private String host = "localhost";
    private String port = "1521";
    private String sid = "xe";
    private String username = "hello";
    private String password = "newpassword";
}
