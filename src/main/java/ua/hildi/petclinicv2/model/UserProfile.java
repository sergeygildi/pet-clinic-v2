package ua.hildi.petclinicv2.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.util.Objects;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@ToString
public class UserProfile extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 6529028956634326182L;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	@Column
	private String address;

	@Column
	private String address2;

	@Column
	private String city;

	@Column
	@Size(min = 2)
	private String state;

	@Column
	@Size(min = 5, max = 10)
	private String zip;

	@Column
	private String phone;

	public UserProfile() {}

	public UserProfile(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UserProfile that = (UserProfile) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
