package ua.hildi.petclinicv2.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity {

	@Serial
	private static final long serialVersionUID = -6307992799720112368L;

}
