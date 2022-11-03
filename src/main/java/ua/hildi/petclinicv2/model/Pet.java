package ua.hildi.petclinicv2.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.util.*;

@Entity
@Table(name = "pets")
@Getter
@Setter
@ToString
public class Pet extends NamedEntity {

	@Serial
	private static final long serialVersionUID = -7523031237057644849L;

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull
	private Date birthDate;

	@ManyToOne
	@JoinColumn(name = "pet_type_id")
	@NotNull
	private PetType type;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	@NotNull
	private Owner owner;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
	private Set<Visit> visits;

	public Pet() {
		super();
	}

	protected Set<Visit> getVisitsInternal() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	public List<Visit> getVisits() {
		List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
		PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedVisits);
	}

	public void addVisit(Visit visit) {
		getVisitsInternal().add(visit);
		visit.setPet(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Pet pet = (Pet) o;
		return id != null && Objects.equals(id, pet.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
