package dev.ruchir.glucosense.model.Core;


import dev.ruchir.glucosense.model.support.Role;
import dev.ruchir.glucosense.model.support.User;
import jakarta.persistence.*;
import lombok.*;

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


    @ManyToOne
    @JoinColumn(name = "chief_doctor_id")
    private ChiefDoctor chiefDoctor;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


}
