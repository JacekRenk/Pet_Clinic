package pl.sdacademy.petclinic.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.petclinic.domain.model.Pet;
import pl.sdacademy.petclinic.domain.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
