package com.kiet.springbootexample.serviceImpl;

import com.kiet.springbootexample.dao.PermissionDao;
import com.kiet.springbootexample.dto.request.PermissionRequestDTO;
import com.kiet.springbootexample.entity.Permission;
import com.kiet.springbootexample.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

  private final PermissionDao permissionDao;

  @Override
  public void createPermission(PermissionRequestDTO dto) {
    Permission permission = Permission.builder()
      .name(dto.getName())
      .build();

    permissionDao.save(permission);
  }
}
