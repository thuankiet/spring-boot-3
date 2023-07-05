package com.kiet.springbootexample.dao;

import com.kiet.springbootexample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
