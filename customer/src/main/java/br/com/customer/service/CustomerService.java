package br.com.customer.service;

import br.com.customer.controller.request.CustomerRequest;
import br.com.customer.controller.response.CustomerResponse;
import br.com.customer.model.CustomerEntity;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest customerRequest);
}
