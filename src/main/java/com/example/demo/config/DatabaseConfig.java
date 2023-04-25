package com.example.demo.config;

import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class DatabaseConfig {

    @Autowired
    private HikariDataSource dataSource;

    @PreDestroy
    public void closeDataSource() {
        if (this.dataSource != null) {
            this.dataSource.close();
        }
    }
}
