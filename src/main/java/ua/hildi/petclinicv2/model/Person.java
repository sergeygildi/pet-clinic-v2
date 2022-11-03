package ua.hildi.petclinicv2.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serial;

@MappedSuperclass
@Data
public class Person extends BaseEntity {

	@Serial
	private static final long serialVersionUID = -4121856840595944702L;

	@Column(name = "first_name")
	@NotEmpty
	protected String firstName;

	@Column(name = "last_name")
	@NotEmpty
	protected String lastName;

}
