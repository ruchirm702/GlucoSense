package dev.ruchir.glucosense.model.Core;

import dev.ruchir.glucosense.model.Enum.MeasurementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "measurement_date", nullable = false)
    private LocalDateTime measurementDate;

    @Column(nullable = false)
    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_type", nullable = false)
    private MeasurementType measurementType;
}
