package pl.milenamrugala.animalsanctuary.model; // packages are used to organize related classes and interfaces into namespaces, helping to avoid name conflicts and to group related functionalities together

import jakarta.persistence.*; // part of the Jakarta Persistence API (formerly JPA, part of Java EE), this API is used for mapping Java objects to database tables
import lombok.*; // a library that reduces boilerplate code by generating common methods like getters, setters, and constructors at compile-time

import java.util.List; // imports the List interface from the java.util package, which represents an ordered collection of objects

@Getter
@Setter
@ToString // a string representation of the object
@NoArgsConstructor // a constructor that takes no parameters
@AllArgsConstructor // a constructor that takes parameters for all fields in the class

@Entity // marks this class as a JPA entity, meaning it maps to a database table
@Inheritance(strategy = InheritanceType.JOINED) // each subclass of Animal will be mapped to its own database table, with a common table for the Animal superclass, this structure allows for sharing some columns between the superclass and subclasses while keeping subclass-specific data in separate tables
public abstract class Animal { // declaring the Animal class as abstract, means it cannot be instantiated directly

    @Id // the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies that the ID should be generated automatically by the database, often used with auto-incremented fields in databases
    private Long id;
    private String name;
    private String species;

    @Column(length = 1500) // the field can store up to 1500 characters
    private String status;
    private boolean isDangerous;
    private boolean isDisabled;

    @OneToMany(mappedBy = "animal") // each Animal can have multiple MedicalRecord entries
    private List<MedicalRecord> medicalRecords; // a list to store all medical records associated with the animal

    @OneToMany(mappedBy = "animal") // each Animal can have multiple sponsorships
    private List<Sponsorship> sponsorships; // a list to store all sponsorships associated with the animal

    @ManyToMany // each animal can have multiple caretakers, and each caretaker can take care of multiple animals
    @JoinTable(
            name = "animal_caretaker",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "caretaker_id")
    )
    private List<User> caretakers; // a list to store all caretakers responsible for the animal
}
