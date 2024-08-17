package pl.milenamrugala.animalsanctuary.model; // packages are used to organize related classes and interfaces into namespaces, helping to avoid name conflicts and to group related functionalities together

import jakarta.persistence.*; // part of the Jakarta Persistence API (formerly JPA, part of Java EE), this API is used for mapping Java objects to database tables
import lombok.*; // a library that reduces boilerplate code by generating common methods like getters, setters, and constructors at compile-time

@Getter
@Setter
@ToString // a string representation of the object
@NoArgsConstructor // a constructor that takes no parameters
@AllArgsConstructor // a constructor that takes parameters for all fields in the class

@Entity // marks this class as a JPA entity, meaning it maps to a database table
public class Role {

    @Id // the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies that the ID should be generated automatically by the database, often used with auto-incremented fields in databases
    private Long id;

    @Enumerated(EnumType.STRING) // the enum value should be stored as a string in the database
    @Column(unique = true) // each value in the column must be unique, and no duplicates are allowed
    private RoleType roleType;

}

