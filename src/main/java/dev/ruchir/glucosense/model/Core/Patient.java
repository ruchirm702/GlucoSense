package dev.ruchir.glucosense.model.Core;

import dev.ruchir.glucosense.model.Enum.BloodType;
import dev.ruchir.glucosense.model.Enum.Gender;
import dev.ruchir.glucosense.model.support.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends User {

    @Column(unique = true)
    private String email; // Add this line

    private LocalDate dateOfBirth;
    private BloodType bloodType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "patient")
    private List<BloodSugarRecord> bloodSugarRecords;

    @OneToMany(mappedBy = "patient")
    private List<DietEntry> dietEntries;

    @OneToMany(mappedBy = "patient")
    private List<ActivityRecord> activityRecords;

    @OneToMany(mappedBy = "patient")
    private List<Measurement> measurements;

    @OneToMany(mappedBy = "patient")
    private List<Allergy> allergies;

    @OneToOne(mappedBy = "patient")
    private EmergencyContact emergencyContact;

    @OneToMany(mappedBy = "patient")
    private List<LabResult> labResults;

    @OneToMany(mappedBy = "patient")
    private List<Medication> medications;
}
