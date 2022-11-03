package ua.hildi.petclinicv2.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;

@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {

	@Serial
	private static final long serialVersionUID = -3562707899528621917L;

}
