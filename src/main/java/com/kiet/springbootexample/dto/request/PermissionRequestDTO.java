package com.kiet.springbootexample.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionRequestDTO {
  @NotNull("Permission name must not be null")
  private String name;
}
