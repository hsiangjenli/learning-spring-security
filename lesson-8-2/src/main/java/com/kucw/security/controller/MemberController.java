package com.kucw.security.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import com.kucw.security.dao.MemberDao;
import com.kucw.security.model.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MemberController {

  @Autowired
  private MemberDao memberDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public String register(@RequestBody Member member) {

    String password = member.getPassword();
    String encodedPassword = passwordEncoder.encode(password);
    member.setPassword(encodedPassword);

    Integer memberId = memberDao.createMember(member);

    return "註冊成功";

  }

  @PostMapping("/userLogin")
  public String userLogin(Authentication authentication) {

    // 帳密驗證 spring security 已經處理完畢

    // 獲得 user 資訊
    String username = authentication.getName();

    // 取得使用者權限
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

    return "登入成功，帳號：" + username + "權限：" + authorities;
  }



}
