package ua.hildi.petclinicv2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin implements Serializable {

    @Serial
    private static final long serialVersionUID = -4125375148974056378L;

    @Column(unique = true)
    public String username;

    @Id
    public String series;

    @Column
    public String token;

    @Column
    @NotNull
    public Date lastUsed;
}
