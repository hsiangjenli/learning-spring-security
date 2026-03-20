package com.kucw.security.controller;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(Authentication authentication) {

        String username = authentication.getName();

        // 取得使用者的權限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return "Hello " + username + "!";
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
