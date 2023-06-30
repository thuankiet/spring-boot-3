package com.kiet.springbootexample.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private String statusCode;
  private String title;
  private String detail;
//  private List<String> fieldError;
}
