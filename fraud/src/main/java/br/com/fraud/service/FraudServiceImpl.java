package br.com.fraud.service;

import br.com.fraud.model.FraudEntity;
import br.com.fraud.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudServiceImpl implements  FraudService{

    private final FraudRepository fraudRepository;

    public FraudServiceImpl(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    @Override
    public boolean isFraud(Long customerId) {
        var fraud = this.fraudRepository.save(
                FraudEntity.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .description("This is not a fraud")
                        .createAt(LocalDateTime.now())
                        .build());
        return fraud.isFraud();
    }
}
