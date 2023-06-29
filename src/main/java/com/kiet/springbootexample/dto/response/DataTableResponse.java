package com.kiet.springbootexample.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataTableResponse {
  private Object data;
  private Long totalElements;
  private Integer totalPages;
}
