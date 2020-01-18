package pl.sdacademy.petclinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sdacademy.petclinic.domain.model.Owner;
import pl.sdacademy.petclinic.domain.repository.OwnerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OwnerService {

	private final OwnerRepository ownerRepository;

	public void createOwner(Owner owner) {
		ownerRepository.save(owner);
	}

	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	public Optional<Owner> getOwnerById(Integer id) {
		return ownerRepository.findById(id);
	}

	public void editOwner(Owner owner) {
		ownerRepository.save(owner);
	}

	public List<Owner> findAllByLastNameContaining(String lastName) {
		return ownerRepository.findAllByLastNameContaining(lastName);
	}

	public void deleteById(Integer id) {
		ownerRepository.deleteById(id);
	}
}

