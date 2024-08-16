package dev.ruchir.glucosense.model.Core;

import dev.ruchir.glucosense.model.support.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Doctor")
public class Doctor extends User {

    // Doctor-specific fields
    @Column(length = 100, nullable = false)
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "chief_doctor_id") // Adjust the column name as needed
    private ChiefDoctor chiefDoctor;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;

}
