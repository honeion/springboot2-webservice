package com.honeion.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
h2 테스트 확인
main 메소드 실행 후 http://localhost:8080/h2-console
JDBC URL : jdbc:h2:mem:testdb
 */