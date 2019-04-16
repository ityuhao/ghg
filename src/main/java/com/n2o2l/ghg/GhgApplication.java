package com.n2o2l.ghg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.n2o2l.ghg.mapper")
@SpringBootApplication
public class GhgApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhgApplication.class, args);
    }

}

