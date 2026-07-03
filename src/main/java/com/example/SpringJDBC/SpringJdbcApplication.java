package com.example.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

}
