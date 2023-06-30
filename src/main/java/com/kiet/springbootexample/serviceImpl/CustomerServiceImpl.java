package com.kiet.springbootexample.serviceImpl;

import com.kiet.springbootexample.constant.MessageConstant;
import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.dto.request.CustomerRequestDTO;
import com.kiet.springbootexample.dto.response.CustomerResponse;
import com.kiet.springbootexample.dto.response.DataTableResponse;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.exception.NotFoundException;
import com.kiet.springbootexample.mapper.CustomerInterfaceProjectionMapper;
import com.kiet.springbootexample.mapper.CustomerMapper;
import com.kiet.springbootexample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerDao customerDao;
  private final CustomerMapper customerMapper;

  @Override
  public CustomerResponse getCustomer(Long id) {
    Customer customer = customerDao.findById(id).orElse(null);
    if (customer == null) {
      throw new NotFoundException(MessageConstant.USER_NOT_FOUND, id);
    }
    return customerMapper
      .convertToCustomerResponse(customer);
  }

  @Override
  public List<CustomerResponse> getCustomers() {
    return customerDao
      .findAll()
      .stream()
      .map(customerMapper::convertToCustomerResponse)
      .toList();
  }

  @Override
  public void save(CustomerRequestDTO dto) {
    Customer customer = Customer.builder()
      .firstname(dto.getFirstname())
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
      customer.setFirstname(dto.getFirstname());
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

  @Override
  public DataTableResponse getCustomerPage(Integer pageNo, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
    Page<CustomerInterfaceProjectionMapper> customerPage = customerDao.findAllProjectedBy(pageable);

    DataTableResponse dataTableResponse = DataTableResponse.builder()
      .data(customerPage.stream().toList())
      .totalElements(customerPage.getTotalElements())
      .totalPages(customerPage.getTotalPages())
      .build();
    return dataTableResponse;
  }
}
