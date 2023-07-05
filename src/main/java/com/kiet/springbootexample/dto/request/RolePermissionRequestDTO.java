package com.kiet.springbootexample.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolePermissionRequestDTO {
  private Long roleId;
  private Long permissionId;
}
