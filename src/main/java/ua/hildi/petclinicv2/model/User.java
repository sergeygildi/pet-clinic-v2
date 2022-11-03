package ua.hildi.petclinicv2.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
@Slf4j
@Getter
@Setter
@ToString
public class User extends BaseEntity implements UserDetails {

	@Serial
	private static final long serialVersionUID = 2002390446280945447L;

	@Column(unique = true)
	@NotEmpty
	private String username;

	@Column
	@NotEmpty
	@Size(min = 5)
	private String password;

	@Transient
	private String uiPassword;

	@Transient
	private String verifyPassword;

	@Column(unique = true)
	@NotEmpty
	@Email
	private String email;

	@Column
	@NotEmpty
	private String name;

	@Column(name = "account_expired")
	private boolean accountExpired = false;

	@Column(name = "account_locked")
	private boolean accountLocked = false;

	@Column(name = "credentials_expired")
	private boolean credentialsExpired = false;

	@Column
	private boolean enabled = true;

	@Transient
	private boolean passwordEncrypted = true;

	@Transient
	private boolean verifyPasswordEncrypted = true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Collection<Authority> authorities;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private UserProfile userProfile;

	public User() {
		passwordEncrypted = false;
		verifyPasswordEncrypted = false;
	}

	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public void setUiPassword(String uiPassword) {
		this.uiPassword = uiPassword;
		setPassword(new BCryptPasswordEncoder().encode(uiPassword));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public boolean hasAuthority(String targetAuthority) {
		if (targetAuthority == null) {
			return false;
		}
		if (authorities == null) {
			log.warn("authorities is null for user " + this);
		}

		for (Authority authority : authorities) {
			if (targetAuthority.equals(authority.getAuthority())) {
				return true;
			}
		}

		return false;
	}

	public void addAuthority(Authority authority) {
		if (authority == null) {
			return;
		}
		if (authorities == null) {
			log.warn("authorities is null for user " + this);
			authorities = new ArrayList<Authority>();
		}

		authorities.add(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void validateCreateUser(ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		if (!StringUtils.equals(uiPassword, verifyPassword)) {
			messages.addMessage(new MessageBuilder().error().source("password").source("verifyPassword")
					.defaultText("Passwords must be the same.").build());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;
		return id != null && Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
