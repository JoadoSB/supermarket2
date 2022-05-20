package br.com.customer.service;

import br.com.customer.config.ConvertUtils;
import br.com.customer.controller.request.CustomerRequest;
import br.com.customer.controller.response.CustomerResponse;
import br.com.customer.model.CustomerEntity;
import br.com.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    private final ConvertUtils convertUtils;

    public CustomerServiceImpl(CustomerRepository customerRepository, ConvertUtils convertUtils) {
        this.customerRepository = customerRepository;
        this.convertUtils = convertUtils;
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        log.info("Calling the method to create customer {}", customerRequest);
        var customerEntity = (CustomerEntity) this.convertUtils.convertRequestToEntity(customerRequest, CustomerEntity.class);

        var entity = this.customerRepository.save(customerEntity);
        return (CustomerResponse) this.convertUtils.convertEntityToResponse(entity, CustomerResponse.class);
    }
}
