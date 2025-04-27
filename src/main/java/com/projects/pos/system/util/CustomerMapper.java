package com.projects.pos.system.util;

import org.mapstruct.Mapper;

import com.projects.pos.system.dto.response.CustomerResponseDTO;
import com.projects.pos.system.dto.response.CustomerSpecificDetailsResponseDTO;
import com.projects.pos.system.entity.Customer;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<CustomerResponseDTO> entityToDto(List<Customer> customerList);
    CustomerResponseDTO entityToDto(Customer customer);
    CustomerSpecificDetailsResponseDTO entityToSpecialDto(Customer customer);
}
