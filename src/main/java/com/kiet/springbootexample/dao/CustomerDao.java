package com.kiet.springbootexample.dao;

import com.kiet.springbootexample.dto.response.CustomerResponse;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.mapper.CustomerInterfaceProjectionMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Long> {
  Optional<Customer> findByEmail(String email);

  Page<CustomerInterfaceProjectionMapper> findAllProjectedBy(Pageable pageable);
}
