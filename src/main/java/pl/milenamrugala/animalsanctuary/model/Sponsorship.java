package pl.milenamrugala.animalsanctuary.model; // packages are used to organize related classes and interfaces into namespaces, helping to avoid name conflicts and to group related functionalities together

import jakarta.persistence.*; // part of the Jakarta Persistence API (formerly JPA, part of Java EE), this API is used for mapping Java objects to database tables
import lombok.*; // a library that reduces boilerplate code by generating common methods like getters, setters, and constructors at compile-time
import java.math.BigDecimal; // imports the BigDecimal class from the java.math package

@Getter
@Setter
@ToString // a string representation of the object
@NoArgsConstructor // a constructor that takes no parameters
@AllArgsConstructor // a constructor that takes parameters for all fields in the class

@Entity // marks this class as a JPA entity, meaning it maps to a database table
public class Sponsorship {

    @Id // the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies that the ID should be generated automatically by the database, often used with auto-incremented fields in databases
    private Long id;
    private BigDecimal amount;

    @ManyToOne // many Sponsorship instances can be associated with a single Animal instance
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne // many Sponsorship instances can be associated with a single User instance
    @JoinColumn(name = "sponsor_id")
    private User sponsor;
}