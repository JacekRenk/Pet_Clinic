package pl.sdacademy.petclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.domain.model.Owner;
import pl.sdacademy.petclinic.domain.model.Pet;
import pl.sdacademy.petclinic.domain.repository.OwnerRepository;
import pl.sdacademy.petclinic.domain.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

	private final PetRepository petRepository;
	private final OwnerService ownerService;

	public void create(Pet pet, Integer ownerId) {
		Optional<Owner> owner = ownerService.getOwnerById(ownerId);

		owner.ifPresent(pet::setOwner);

//		if (owner.isPresent()) {
//			pet.setOwner(owner.get());
//		}

		petRepository.save(pet);
	}

	public Optional<Pet> getPetById(Integer petId) {
		return petRepository.findById(petId);
	}
}

