package pl.milenamrugala.animalsanctuary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) //the enum value should be stored as a string in the database
    @Column(unique = true) //each value in the column must be unique, and no duplicates are allowed
    private RoleType roleType;

}

