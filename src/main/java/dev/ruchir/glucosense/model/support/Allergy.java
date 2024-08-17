package dev.ruchir.glucosense.model.support;


import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.Enum.AllergyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String allergen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AllergyType type;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
