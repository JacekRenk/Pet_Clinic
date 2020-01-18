package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.domain.model.Pet;
import pl.sdacademy.petclinic.service.PetService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pet")
@Slf4j
public class PetController {

	private final PetService petService;

	@GetMapping("/create/{ownerId}")
	public String createPetForm(Model model, @PathVariable("ownerId") Integer ownerId) {
		model.addAttribute("pet", new Pet());
		model.addAttribute("ownerId", ownerId);
		return "pet/form";
	}

	@PostMapping("/create/{ownerId}")
	public String createPet(@ModelAttribute("pet") Pet pet, @PathVariable("ownerId") Integer ownerId) {
		petService.create(pet, ownerId);

		return "redirect:/owner/list";
	}


}
