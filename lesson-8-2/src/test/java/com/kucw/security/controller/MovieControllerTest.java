package com.kucw.security.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getMovies_normalMember_success() throws Exception {}

  @Test
  public void watchFreeMovie_normalMember_success() throws Exception {}

  @Test
  public void watchFreeMovie_vipMember_success() throws Exception {}

  @Test
  public void watchVipMovie_normalMember_fail() throws Exception {}

  @Test
  public void watchVipMovie_vipMember_success() throws Exception {}

  @Test
  public void uploadMovie_normalMember_vipMember_fail() throws Exception {}

  @Test
  public void uploadMovie_movieManager_admin_success() throws Exception {}

  @Test
  public void deleteMovie_normalMember_vipMember_fail() throws Exception {}

  @Test
  public void deleteMovie_movieManager_admin_success() throws Exception {}
}
