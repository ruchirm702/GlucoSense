package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.support.ConcreteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcreteUserRepository extends JpaRepository<ConcreteUser, Long> {
    ConcreteUser findByUsername(String username);
}
