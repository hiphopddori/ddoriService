package com.ddori.service.app.web;

import com.ddori.service.app.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name ,
                                     @RequestParam("amount") int amount){

        HelloResponseDto dto = HelloResponseDto.builder().name(name).amount(amount).build();
        //return new HelloResponseDto(name,amount);
        return dto;
    }

}


