package dev.ruchir.glucosense.model.Core;

import dev.ruchir.glucosense.model.Enum.DietType;
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
@Table(name = "diet_entry")
public class DietEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDateTime entryDate;

    @Column(nullable = false)
    private String foodItem;

    private Integer calories;

    @Enumerated(EnumType.STRING)
    private DietType dietType;
}
