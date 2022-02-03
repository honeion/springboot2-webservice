package com.honeion.study.springboot.web;

import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 테스트 진행시 Jnuit에 내장된 실행자 외에 SpringRunner 사용(스프링부트 테스트와 JUnit 연결)
@WebMvcTest(controllers = HelloController.class) //이번 테스트는 Spring MVC 컨트롤러만 사용해서 선언
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //웹 API 테스트 시 사용

    @Test
    public void ReturnHello() throws Exception{
        String hello ="HELLO";

        mvc.perform(get("/hello")) // /hello로 HTTP GET 요청
                .andExpect(status().isOk())  // perform 결과 200인지 검증
                .andExpect(content().string(hello)); // 응답값 동일한지 검증
    }

    @Test
    public void ReturnHelloDto() throws Exception {
        String name ="hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //json 응답값 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
