package pl.milenamrugala.animalsanctuary.model; // packages are used to organize related classes and interfaces into namespaces, helping to avoid name conflicts and to group related functionalities together

import jakarta.persistence.*; // part of the Jakarta Persistence API (formerly JPA, part of Java EE), this API is used for mapping Java objects to database tables
import lombok.*; // a library that reduces boilerplate code by generating common methods like getters, setters, and constructors at compile-time
import java.util.List; // imports the List interface from the java.util package, which represents an ordered collection of objects
import java.util.Set; // imports the Set interface from the java.util package, a Set represents an unordered collection of unique objects, meaning duplicates are not allowed

@Getter
@Setter
@ToString // a string representation of the object
@NoArgsConstructor // a constructor that takes no parameters
@AllArgsConstructor // a constructor that takes parameters for all fields in the class

@Entity // marks this class as a JPA entity, meaning it maps to a database table
public class User {

    @Id // the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies that the ID should be generated automatically by the database, often used with auto-incremented fields in databases
    private Long id;


    @Column(unique = true, nullable = false) // the email is unique and cannot be null
    private String email;

    private String password;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER) // a user can have multiple roles, and a role can be assigned to multiple users
    // loading roles eagerly - JPA will immediately also load all roles associated with this user
    @JoinTable(
            name = "user_roles", // name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // foreign key referencing the user entity
            inverseJoinColumns = @JoinColumn(name = "role_id") // foreign key referencing the role entity
    )
    private Set<Role> roles; // a set of roles assigned to the user, each role is unique (no duplicates)

    @OneToMany(mappedBy = "user") // a user can have multiple adoptions, the user field in the Adopt class is the owner of the relationship
    private List<Adopt> adoptions; // the list of adoptions associated with the user

}
