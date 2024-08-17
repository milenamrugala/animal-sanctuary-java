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
public class Adopt {

    @Id // the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies that the ID should be generated automatically by the database, often used with auto-incremented fields in databases
    private Long id;

    @OneToOne // each Adopt instance is associated with exactly one Animal instance
    @JoinColumn(name = "animal_id", unique = true) // the animal_id value is unique, meaning each animal can only be adopted once
    private Animal animal;

    @ManyToOne // many Adopt instances can be associated with the same User instance (a user can adopt multiple animals)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

    @Column(name = "is_permanent")
    private boolean isPermanent = true; // by default, adoptions are considered permanent

}