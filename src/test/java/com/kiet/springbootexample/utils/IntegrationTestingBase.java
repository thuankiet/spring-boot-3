package com.kiet.springbootexample.utils;

import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
public class IntegrationTestingBase {
  public static final String API_ROOT_PATH = "http://localhost:8085/api/v1";
}
