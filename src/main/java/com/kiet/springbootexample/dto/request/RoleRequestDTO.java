package com.kiet.springbootexample.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDTO {
  @NotNull("Role name must not be empty")
  private String name;
}
