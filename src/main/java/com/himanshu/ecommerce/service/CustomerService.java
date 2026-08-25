package com.himanshu.ecommerce.service;

import com.himanshu.ecommerce.dto.CustomerRequest;
import com.himanshu.ecommerce.dto.CustomerResponse;
import com.himanshu.ecommerce.model.Customer;
import com.himanshu.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerResponse mapToCustomerResponse(Customer customer){

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());

        return  customerResponse;
    }


    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();

        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());

        Customer savedCustomer = customerRepository.save(customer);

        return mapToCustomerResponse(savedCustomer);
    }
}
