package pl.milenamrugala.animalsanctuary.service;

import pl.milenamrugala.animalsanctuary.model.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> getAllAnimals();
    Animal saveAnimal(Animal animal);
    Animal updateAnimal(Animal animal);
    Animal getAnimalById(Long id);
    void deleteAnimalById(Long id);

}
