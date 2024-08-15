package pl.milenamrugala.animalsanctuary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString

@Entity //marks this class as a JPA entity, meaning it maps to a database table
public class User {

    @Id //the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //specifies that the ID should be generated automatically by the database
    private Long id;


    @Column(unique = true, nullable = false) // the email is unique and cannot be null
    private String email;

    private String password;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER) // loading roles eagerly - JPA will immediately also load all roles associated with this user
    @JoinTable(
            name = "user_roles", // name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // foreign key referencing the user entity
            inverseJoinColumns = @JoinColumn(name = "role_id") // foreign key referencing the role entity
    )
    private Set<Role> roles; //a set of roles assigned to the user

}
