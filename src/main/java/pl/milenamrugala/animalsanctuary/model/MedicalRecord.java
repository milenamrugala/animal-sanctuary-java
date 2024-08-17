package pl.milenamrugala.animalsanctuary.model; // packages are used to organize related classes and interfaces into namespaces, helping to avoid name conflicts and to group related functionalities together

import jakarta.persistence.*; // part of the Jakarta Persistence API (formerly JPA, part of Java EE), this API is used for mapping Java objects to database tables
import lombok.*; // a library that reduces boilerplate code by generating common methods like getters, setters, and constructors at compile-time
import java.time.LocalDate; // imports the LocalDate class from the java.time package

@Getter
@Setter
@ToString // a string representation of the object
@NoArgsConstructor // a constructor that takes no parameters
@AllArgsConstructor // a constructor that takes parameters for all fields in the class

@Entity // marks this class as a JPA entity, meaning it maps to a database table
public class MedicalRecord {

    @Id // the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies that the ID should be generated automatically by the database, often used with auto-incremented fields in databases
    private Long id;

    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    private String treatment;

    @Column(name = "is_in_treatment")
    private boolean isInTreatment;

    @ManyToOne // many MedicalRecord instances can be associated with a single Animal instance
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne // many MedicalRecord instances can be associated with a single User instance
    @JoinColumn(name = "vet_id")
    private User vet;

    @Column(name = "end_date")
    private LocalDate endDate;

}