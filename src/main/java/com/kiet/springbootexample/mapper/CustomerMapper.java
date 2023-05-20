package com.kiet.springbootexample.mapper;

import com.kiet.springbootexample.dto.response.CustomerResponse;
import com.kiet.springbootexample.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mappings({
    @Mapping(target = "id", source = "id"),
    @Mapping(target = "lastname", source = "lastname"),
    @Mapping(target = "firstname", source = "firstname"),
    @Mapping(target = "email", source = "email"),
    @Mapping(target = "isActive", source = "isActive"),
    @Mapping(target = "createdDate", source = "createdDate")
  })
  CustomerResponse convertToCustomerResponse(Customer customer);
}
