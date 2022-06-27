package com.example.book_springboot_aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookSpringbootAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSpringbootAwsApplication.class, args);
    }

}
