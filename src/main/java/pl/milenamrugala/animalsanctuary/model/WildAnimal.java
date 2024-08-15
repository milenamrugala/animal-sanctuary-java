package pl.milenamrugala.animalsanctuary.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
public class WildAnimal extends Animal {

    private boolean isEndangered;
    private boolean isVenomous;

}
