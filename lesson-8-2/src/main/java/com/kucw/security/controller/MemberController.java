package com.kucw.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.kucw.security.dao.MemberDao;
import com.kucw.security.model.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MemberController {

  @Autowired
  private MemberDao memberDao;

  @PostMapping("/register")
  public String register(@RequestBody Member member) {

    Integer memberId = memberDao.createMember(member);

    return "註冊成功";
  }


}
