package pl.sdacademy.petclinic.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String date;
	private String description;

	@ManyToOne
	private Pet pet;
}
