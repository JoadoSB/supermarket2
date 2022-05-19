package br.com.customer.controller;

import br.com.customer.controller.request.CustomerRequest;
import br.com.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @Operation(summary = "create customer", description = "create customer to fraud system")
    @ApiResponse(responseCode = "201", description = "Customer success created")
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("calling controller to create customer {}", customerRequest);
        this.customerService.createCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
