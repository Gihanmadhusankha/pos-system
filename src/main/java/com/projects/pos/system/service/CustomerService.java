package com.projects.pos.system.service;

import java.util.List;

import com.projects.pos.system.dto.request.CustomerNameRequestByQueryDTO;
import com.projects.pos.system.dto.request.CustomerRequestDTO;
import com.projects.pos.system.dto.request.CustomerSpecificDetailsRequestDTO;
import com.projects.pos.system.dto.response.CustomerNameResponseDTO;
import com.projects.pos.system.dto.response.CustomerResponseDTO;
import com.projects.pos.system.dto.response.CustomerSpecificDetailsResponseDTO;

public interface CustomerService {
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    public List<CustomerResponseDTO> getAllCustomers();

    public String deleteCustomer(Long id);
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO, Long id);

    public List<CustomerResponseDTO> getActiveCustomers();

    public List<CustomerNameResponseDTO> getActiveCustomersNames();

    String updateCustomersByQuery(CustomerNameRequestByQueryDTO customerNameRequestByQueryDTO, Long id);

    public CustomerResponseDTO getCustomersByNic(String nic);

    public CustomerSpecificDetailsResponseDTO getDetails(Long id);

    public void updateSpecificCustomerDetails(CustomerSpecificDetailsRequestDTO customerSpecificDetailsRequestDTO, Long id);

    public String findActiveOrNot(Long id);
}
