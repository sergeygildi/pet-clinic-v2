package ua.hildi.petclinicv2.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serial;

@MappedSuperclass
@Getter
@Setter
public class NamedEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -1369326166767704974L;

    @Column(name = "name")
    @NotEmpty
    protected String name;

    public NamedEntity() {
        super();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        NamedEntity other = (NamedEntity) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
