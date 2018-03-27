package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class MainTest {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainTest.class, args);
    }

}