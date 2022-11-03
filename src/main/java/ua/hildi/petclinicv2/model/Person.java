package ua.hildi.petclinicv2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serial;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Person extends BaseEntity {

	@Serial
	private static final long serialVersionUID = -4121856840595944702L;

	@Column(name = "first_name")
	protected String firstName;

	@Column(name = "last_name")
	protected String lastName;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Person person = (Person) o;
		return id != null && Objects.equals(id, person.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
