package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.domain.model.Pet;
import pl.sdacademy.petclinic.domain.model.Visit;
import pl.sdacademy.petclinic.service.PetService;
import pl.sdacademy.petclinic.service.VisitService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visit")
@Slf4j
public class VisitController {

	private final VisitService visitService;

	@GetMapping("/create/{petId}")
	public String createVisitForm(Model model, @PathVariable("petId") Integer petId) {
		model.addAttribute("visit", new Visit());
		model.addAttribute("petId", petId);
		return "visit/form";
	}

	@PostMapping("/create/{petId}")
	public String createPet(@ModelAttribute("visit") Visit visit, @PathVariable("petId") Integer petId) {
		visitService.create(visit, petId);

		return "redirect:/visit/list";
	}

	@GetMapping("/list")
	public String visits(Model model) {
		model.addAttribute("visits", visitService.findAll());
		return "visit/list";
	}

	@GetMapping("/edit/{visitId}")
	public String editVisitForm(Model model, @PathVariable("visitId") Integer visitId) {
		Optional<Visit> visit = visitService.findById(visitId);

		if (visit.isPresent()) {
			model.addAttribute("visit", visit.get());
			return "visit/edit-form";
		} else {
			return "redirect:/visit/list";
		}
	}


}
