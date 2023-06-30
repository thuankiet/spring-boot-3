package unit.com.kiet.springbootexample.service;

import com.kiet.springbootexample.dao.CustomerDao;
import com.kiet.springbootexample.dto.response.CustomerResponse;
import com.kiet.springbootexample.entity.Customer;
import com.kiet.springbootexample.exception.NotFoundException;
import com.kiet.springbootexample.mapper.CustomerMapper;
import com.kiet.springbootexample.serviceImpl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

  @Mock
  private CustomerDao customerDao;

  @Mock
  private CustomerMapper customerMapper;

  @InjectMocks
  private CustomerServiceImpl customerService;

  private static final Long CUSTOMER_ID = 1L;

  @Test
  void getCustomerById_Success() {
    Customer customer = Customer.builder()
      .firstname("firstname")
      .lastname("lastname")
      .email("email@example.com")
      .build();
    CustomerResponse customerResponse = CustomerResponse.builder()
      .firstname("firstname")
      .lastname("lastname")
      .email("email@example.com")
      .build();

    Mockito.when(customerDao.findById(CUSTOMER_ID)).thenReturn(Optional.of(customer));
    Mockito.when(customerMapper.convertToCustomerResponse(customer)).thenReturn(customerResponse);
    assertNotNull(customerService.getCustomer(CUSTOMER_ID));
  }

  @Test
  void getCustomerById_NotFoundException() {
    Mockito.when(customerDao.findById(CUSTOMER_ID)).thenReturn(Optional.empty());
    assertThrows(NotFoundException.class, () -> customerService.getCustomer(CUSTOMER_ID));
  }
}
