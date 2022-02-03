package com.honeion.study.springboot.web;

import com.honeion.study.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //@ResponseBody
public class HelloController {

    @GetMapping("/hello") //@RequestMapping(method=RequestMethod.GET)
    public String hello(){
        return "HELLO";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
