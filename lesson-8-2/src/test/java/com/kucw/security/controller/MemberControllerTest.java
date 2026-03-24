package com.kucw.security.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kucw.security.model.Member;


@AutoConfigureMockMvc
@SpringBootTest
public class MemberControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testRegister() throws Exception {

    Member member = new Member();
    member.setAge(50);
    member.setEmail("test1@gmail.com");
    member.setMemberId(55555);
    member.setName("test1");
    member.setPassword("test1");

    String json = objectMapper.writeValueAsString(member);
    RequestBuilder requestBuilder = MockMvcRequestBuilders

        .post("/register")

        .header("Content-Type", "application/json")

        .content(json);

    mockMvc.perform(requestBuilder).andExpect(status().is(200));
  }

  @Test
  void testUserLogin() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders

        .post("/userLogin")

        .with(httpBasic("normal@gmail.com", "normal"));

    mockMvc.perform(requestBuilder).andExpect(status().is(200));
  }
}
