package com.kiet.springbootexample.service;

import com.kiet.springbootexample.dto.request.RoleRequestDTO;
import com.kiet.springbootexample.entity.Role;

import java.util.List;

public interface RoleService {
  List<Role> getRoles();
  void createRole(RoleRequestDTO dto);
  void deleteRole(Long id);
}
