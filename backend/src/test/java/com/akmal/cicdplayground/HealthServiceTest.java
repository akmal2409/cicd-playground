package com.akmal.cicdplayground;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HealthServiceTest {

  @InjectMocks
  HealthService healthService;


  @Test
  void testReturnsHealth() {
    final var status = healthService.getHealth();

    assertThat(status).isNotNull();
    assertThat(status.get("status")).isEqualTo("HEALTHY");
  }
}
