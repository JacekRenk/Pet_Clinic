package pl.sdacademy.petclinic.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.domain.model.Owner;
import pl.sdacademy.petclinic.domain.model.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
