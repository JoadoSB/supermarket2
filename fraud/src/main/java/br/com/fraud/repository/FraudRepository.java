package br.com.fraud.repository;

import br.com.fraud.model.FraudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<FraudEntity, Long> {
}
