package com.kucw.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MyTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testWelcome_noCsrfToken() throws Exception {}

  @Test
  public void testWelcome_withCsrfToken() throws Exception {}

  @Test
  public void testRegister_noCsrfToken() throws Exception {}

}
