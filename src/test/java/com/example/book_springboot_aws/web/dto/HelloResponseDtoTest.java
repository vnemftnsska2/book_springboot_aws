package com.example.book_springboot_aws.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    @DisplayName("롬복 기능 테스트")
    @Test
    public void testLombok() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then (기대할 값을 앞에 두는 게 좋다)
        assertEquals(name, dto.getName());
        assertEquals(amount, dto.getAmount());
    }
}