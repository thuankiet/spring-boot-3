package com.kiet.springbootexample.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
  private Long id;
  private String firstname;
  private String lastname;
  private String email;
  private Integer isActive;
  private Date createdDate;
}
