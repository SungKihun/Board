package com.example.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello test";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello GET test";
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("name") String name) {
        return "Hello" + name;
    }
}
