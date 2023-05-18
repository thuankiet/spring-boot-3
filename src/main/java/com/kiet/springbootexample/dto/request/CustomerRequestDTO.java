package com.kiet.springbootexample.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
  private Long id;
  private String name;
  private String email;
  private Integer age;
}
