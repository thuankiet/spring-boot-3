package com.kiet.springbootexample.service;

import com.kiet.springbootexample.dto.request.CustomerRequestDTO;
import com.kiet.springbootexample.dto.response.CustomerResponse;
import com.kiet.springbootexample.dto.response.DataTableResponse;
import com.kiet.springbootexample.entity.Customer;

import java.util.List;

public interface CustomerService {
  CustomerResponse getCustomer(Long id);

  List<CustomerResponse> getCustomers();

  void save(CustomerRequestDTO dto);

  void update(CustomerRequestDTO dto);

  void delete(Long id);

  DataTableResponse getCustomerPage(Integer pageNo, Integer pageSize);
}
