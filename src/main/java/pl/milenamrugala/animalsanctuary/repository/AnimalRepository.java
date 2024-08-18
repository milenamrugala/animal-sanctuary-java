package pl.milenamrugala.animalsanctuary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.milenamrugala.animalsanctuary.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
