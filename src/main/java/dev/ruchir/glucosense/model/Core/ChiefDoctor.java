package dev.ruchir.glucosense.model.Core;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class ChiefDoctor extends Doctor {

    @OneToMany(mappedBy = "chiefDoctor")
    private List<Doctor> doctors;

}
