package com.honeion.study.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
//CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음

public class HelloResponseDtoTest {

    @Test
    public void testForLombok(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //assertj 테스트 검증 라이브러리 검증 메소드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
