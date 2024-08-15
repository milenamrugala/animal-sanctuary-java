package pl.milenamrugala.animalsanctuary.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
public class DomesticatedAnimal extends Animal {

    private boolean readyToAdopt;

}