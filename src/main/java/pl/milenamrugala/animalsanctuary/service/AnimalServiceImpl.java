package pl.milenamrugala.animalsanctuary.service;

import org.springframework.stereotype.Service;
import pl.milenamrugala.animalsanctuary.model.Animal;
import pl.milenamrugala.animalsanctuary.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).get();
    }

    @Override
    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);

    }
}