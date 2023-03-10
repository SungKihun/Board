package com.example.board.controller;

import com.example.board.domain.ResultVO;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/hello5")
    public ResultVO hello5(@RequestParam("name") String name) {
        return new ResultVO(0, name);
    }

    @PostMapping("/hello6")
    public ResultVO hello6(@RequestBody ResultVO result) {
        return result;
    }
}
