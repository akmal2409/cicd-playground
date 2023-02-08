package com.akmal.cicdplayground;

import java.util.Collections;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

  public Map<String, String> getHealth() {
    return Collections.singletonMap("status", "HEALTHY");
  }
}
