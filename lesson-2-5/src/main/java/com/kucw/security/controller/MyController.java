package com.kucw.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping("/deny-all")
    public String denyAll() {
        return "deny all";
    }

}
