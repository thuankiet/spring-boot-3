package com.kiet.springbootexample.serviceImpl;

import com.kiet.springbootexample.constant.MessageConstant;
import com.kiet.springbootexample.dao.RoleDao;
import com.kiet.springbootexample.dto.request.RoleRequestDTO;
import com.kiet.springbootexample.entity.Role;
import com.kiet.springbootexample.exception.NotFoundException;
import com.kiet.springbootexample.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
  private final RoleDao roleDao;

  @Override
  public List<Role> getRoles() {
    return roleDao.findAll();
  }

  @Override
  @Transactional
  public void createRole(RoleRequestDTO dto) {
    Role role = Role.builder()
      .name(dto.getName())
      .build();
    roleDao.save(role);
  }

  @Override
  public void deleteRole(Long id) {
    Role role = roleDao.findById(id).orElse(null);
    if (role == null) {
      throw new NotFoundException(MessageConstant.ROLE_NOT_FOUND, id);
    }

    roleDao.delete(role);
  }
}
