package dev.ruchir.glucosense.model.support;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "concrete_users") // Updated table name for clarity
@Getter
@Setter
public class ConcreteUser extends User {
    private String email;

}
