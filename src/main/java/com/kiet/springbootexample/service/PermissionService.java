package com.kiet.springbootexample.service;

import com.kiet.springbootexample.dto.request.PermissionRequestDTO;

public interface PermissionService {
  void createPermission(PermissionRequestDTO dto);
}
