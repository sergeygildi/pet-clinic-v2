package ua.hildi.petclinicv2.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin implements Serializable {

	@Serial
	private static final long serialVersionUID = -4125375148974056378L;

	@Column(unique = true)
	@NotEmpty
	public String username;

	@Id
	public String series;

	@Column
	@NotEmpty
	public String token;

	@Column
	@NotNull
	public Date lastUsed;
}
