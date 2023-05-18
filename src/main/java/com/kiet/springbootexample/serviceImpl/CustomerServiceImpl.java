package com.kiet.springbootexample.serviceImpl;

import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.dto.request.CustomerRequestDTO;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerDao customerDao;

  @Override
  public Customer getCustomer(Long id) {
    return customerDao.findById(id).orElse(null);
  }

  @Override
  public List<Customer> getCustomers() {
    return customerDao.findAll();
  }

  @Override
  public void save(CustomerRequestDTO dto) {
    Customer customer = Customer.builder()
      .name(dto.getName())
      .email(dto.getEmail())
      .age(dto.getAge())
      .build();
    customerDao.save(customer);
  }

  @Override
  public void update(CustomerRequestDTO dto) {
    Customer customer = customerDao.findById(dto.getId()).orElse(null);
    if (customer != null) {
      customer.setEmail(dto.getEmail());
      customer.setName(dto.getName());
      customer.setAge(dto.getAge());
      customerDao.save(customer);
    }
  }

  @Override
  public void delete(Long id) {
    Customer customer = customerDao.findById(id).orElse(null);
    if (customer != null) {
      customerDao.delete(customer);
    }
  }
}
