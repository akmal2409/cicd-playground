package com.akmal.cicdplayground;

import java.util.Collections;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HealthController.class)
class HealthControllerIT {

  @MockBean
  HealthService healthService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testReturnsHealthy() throws Exception {
    when(healthService.getHealth()).thenReturn(Collections.singletonMap("status", "HEALTHY"));
    mockMvc.perform(get("/health")
                        .accept("application/json"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status", is("HEALTHY")));
  }
}
