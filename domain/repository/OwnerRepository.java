package pl.sdacademy.petclinic.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.petclinic.domain.model.Owner;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

	List<Owner> findAllByLastNameContaining(String lastName);
}
