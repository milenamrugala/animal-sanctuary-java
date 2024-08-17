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
public class Adopt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "animal_id", unique = true)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

    @Column(name = "is_permanent")
    private boolean isPermanent = true; // by default, adoptions are permanent

}