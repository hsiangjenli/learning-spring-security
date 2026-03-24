package com.kucw.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
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


}
