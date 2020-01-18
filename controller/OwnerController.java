package pl.sdacademy.petclinic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.petclinic.domain.model.Owner;
import pl.sdacademy.petclinic.model.FilterForm;
import pl.sdacademy.petclinic.service.OwnerService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owner")
@Slf4j
public class OwnerController {

	private final OwnerService ownerService;

	@GetMapping("/create")
	public String createOwnerForm(Model model) {
		model.addAttribute("owner", new Owner());
		return "owner/form";
	}

	@PostMapping("/create")
	public String createOwner(@ModelAttribute("owner") Owner owner) {
		ownerService.createOwner(owner);
		log.info("Created new owner {}", owner);

		return "redirect:/owner/list";
	}

	@GetMapping("/edit/{id}")
	public String editOwnerForm(@PathVariable("id") Integer id, Model model) {
		Optional<Owner> maybeOwner = ownerService.getOwnerById(id);

		if (maybeOwner.isEmpty()) {
			return "redirect:/owner/create";
		} else {
			model.addAttribute("owner", maybeOwner.get());
			return "owner/edit-form";
		}
	}

	@PostMapping("/edit/{id}")
	public String editOwner(@ModelAttribute("owner") Owner owner) {
		ownerService.editOwner(owner);

		return "redirect:/owner/list";
	}

	@GetMapping("/list")
	public String ownerList(Model model) {
		List<Owner> owners = ownerService.getAllOwners();
		model.addAttribute("owners", owners);

		return "owner/list";
	}

	@GetMapping("/find-by-last-name")
	public String findByLastNameForm(Model model) {
		model.addAttribute("filterForm", new FilterForm());
		return "owner/find";
	}

	@PostMapping("/find-by-last-name")
	public String findByLastNameForm(@ModelAttribute("filterForm") FilterForm filterForm,
									 Model model) {
		List<Owner> owners = ownerService.findAllByLastNameContaining(filterForm.getLastName());
		model.addAttribute("owners", owners);
		return "owner/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		ownerService.deleteById(id);

		return "redirect:/owner/list";
	}
}
