package pl.milenamrugala.animalsanctuary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.milenamrugala.animalsanctuary.service.AnimalService;

@Controller
@RequestMapping(value = "/animal-sanctuary")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        super();
        this.animalService = animalService;
    }

    @GetMapping("/all-animals")
    public String allAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "all-animals";
    }
}
