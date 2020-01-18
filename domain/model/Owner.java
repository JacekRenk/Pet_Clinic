package pl.sdacademy.petclinic.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Owner {

	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String telephone;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Pet> pets;
}
