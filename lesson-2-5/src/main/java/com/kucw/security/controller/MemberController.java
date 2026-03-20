package com.kucw.security.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kucw.security.dao.MemberDao;
import com.kucw.security.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MemberController {

  @Autowired
  private MemberDao memberDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public Member register(@RequestBody Member member) {

    String hashedPassword = passwordEncoder.encode(member.getPassword());
    member.setPassword(hashedPassword);

    // 先 pass 參數檢查，因為跟 Spring Security
    Integer memberId = memberDao.createMember(member);

    return memberDao.getMemberById(memberId);
  }


}
