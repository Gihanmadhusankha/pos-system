package com.projects.pos.system.controller;

import com.projects.pos.system.dto.request.CustomerNameRequestByQueryDTO;
import com.projects.pos.system.dto.request.CustomerRequestDTO;
import com.projects.pos.system.dto.request.CustomerSpecificDetailsRequestDTO;
import com.projects.pos.system.dto.response.CustomerNameResponseDTO;
import com.projects.pos.system.dto.response.CustomerResponseDTO;
import com.projects.pos.system.dto.response.CustomerSpecificDetailsResponseDTO;
import com.projects.pos.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/create-customer")
    public CustomerResponseDTO createCustomers(@RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customerRequestDTO);
        return customerResponseDTO;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerResponseDTO> getAllCustomers(){
        List<CustomerResponseDTO> customerResponseDTOList = customerService.getAllCustomers();
        return customerResponseDTOList;
    }

    @DeleteMapping(path = "/delete-single-customer", params = "customerId")
    public String deleteCustomers(@RequestParam("customerId") Long id){
        String msg = customerService.deleteCustomer(id);
        return msg;
    }

    @PutMapping(path = "/update-single-customer", params = "customerId")
    public CustomerResponseDTO updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO, @RequestParam("customerId") Long id){
        CustomerResponseDTO customerResponseDTO = customerService.update(customerRequestDTO,id);
        return customerResponseDTO;
    }

    @GetMapping(path = "/get-active-customers")
    public List<CustomerResponseDTO> getActiveCustomers(){
        List<CustomerResponseDTO> customerResponseDTOS = customerService.getActiveCustomers();
        return customerResponseDTOS;
    }

    @GetMapping(path = "/get-active-customers-names")
    public List<CustomerNameResponseDTO> getActiveCustomersNames(){
        List<CustomerNameResponseDTO> customerResponseDTOS = customerService.getActiveCustomersNames();
        return customerResponseDTOS;
    }

    @PutMapping(path = "update-customers-by-query",params = "customerId")
    public String updateCustomerUsingQuery(@RequestBody CustomerNameRequestByQueryDTO customerNameRequestByQueryDTO , @RequestParam("customerId") Long id){
        String msg = customerService.updateCustomersByQuery(customerNameRequestByQueryDTO,id);
        return msg;
    }

    @GetMapping(path = "/get-by-nic", params = "customerNic")
    public CustomerResponseDTO getCustomersById(@RequestParam("customerNic") String nic){
        CustomerResponseDTO customerResponseDTO = customerService.getCustomersByNic(nic);
        return customerResponseDTO;
    }

    @GetMapping(path = "/get-spec-by-id", params = "customerId")
    public CustomerSpecificDetailsResponseDTO getSpecCustomerById(@RequestParam("customerId") Long id){
        CustomerSpecificDetailsResponseDTO customerSpecificDetailsResponseDTO = customerService.getDetails(id);
        return customerSpecificDetailsResponseDTO;
    }

    @PutMapping(path = "/update-specific-details" , params = "customerId")
    public String updateSpecificCustomerDetails(@RequestBody CustomerSpecificDetailsRequestDTO customerSpecificDetailsRequestDTO , @RequestParam("customerId") Long id){
        customerService.updateSpecificCustomerDetails(customerSpecificDetailsRequestDTO , id);
        return "Updated sucessfully ID: "+ id;
    }

    @GetMapping(path = "/active" , params = "customerId")
    public String findActiveOrNotUsingID(@RequestParam("customerId") Long id){
        String msg = customerService.findActiveOrNot(id);
        return msg;
    }
}
