package br.com.fraud.controller;

import br.com.fraud.service.FraudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/frauds")
public class FraudController {

    private final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping("/is-fraud/{customerId}")
    public Boolean isFraud(@PathVariable("customerId") Long customerId) {
        return this.fraudService.isFraud(customerId);
    }
}
