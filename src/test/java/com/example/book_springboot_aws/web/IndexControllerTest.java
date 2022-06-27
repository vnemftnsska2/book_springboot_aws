package com.example.book_springboot_aws.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("메인 페이지 로딩")
    @Test
    public void indexPage() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertTrue(body.contains("스프링 부트로 시작하는 웹 서비스"));
    }
}