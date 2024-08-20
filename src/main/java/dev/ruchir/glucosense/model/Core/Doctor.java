package dev.ruchir.glucosense.model.Core;

import dev.ruchir.glucosense.model.support.Role;
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
@Table(name = "doctor")
public class Doctor extends User {

    @Column(length = 100, nullable = false)
    private String specialization;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_doctor_id")
    private ChiefDoctor chiefDoctor;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}
