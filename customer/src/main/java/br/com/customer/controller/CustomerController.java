package br.com.customer.controller;

import br.com.customer.controller.request.CustomerRequest;
import br.com.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("calling controller to create customer {}", customerRequest);
        this.customerService.createCustomer(customerRequest);
    }
}
