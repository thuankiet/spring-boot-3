package com.kiet.springbootexample.service;

import com.kiet.springbootexample.dto.request.CustomerRequestDTO;
import com.kiet.springbootexample.entity.Customer;

import java.util.List;

public interface CustomerService {
  Customer getCustomer(Long id);

  List<Customer> getCustomers();

  void save(CustomerRequestDTO dto);

  void update(CustomerRequestDTO dto);

  void delete(Long id);
}
