package dev.ruchir.glucosense.model.Core;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(nullable = false)
    private String targetEntityType;  // e.g., "Doctor", "Appointment", "Medication"

    @Column(nullable = false)
    private Long targetEntityId;

    @Column(nullable = false, length = 500)
    private String comments;

    @Column(nullable = false)
    private int rating;  // Rating value, e.g., 1 to 5

    @Column(nullable = false)
    private LocalDate feedbackDate;
}
