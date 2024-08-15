package pl.milenamrugala.animalsanctuary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //the subclasses will be mapped to their own tables
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    private String status;
    private boolean isDangerous;
    private boolean isDisabled;

    @OneToMany(mappedBy = "animal")
    private List<MedicalRecord> medicalRecords;

    @ManyToMany
    @JoinTable(
            name = "animal_sponsor",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "sponsor_id")
    )
    private List<Sponsorship> sponsorships;

    @ManyToMany
    @JoinTable(
            name = "animal_caretaker",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "caretaker_id")
    )
    private List<User> caretakers;
}
