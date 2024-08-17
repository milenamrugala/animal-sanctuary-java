package pl.milenamrugala.animalsanctuary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    private String treatment;

    @Column(name = "is_in_treatment")
    private boolean isInTreatment;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private User vet;

    @Column(name = "end_date")
    private LocalDate endDate;

}