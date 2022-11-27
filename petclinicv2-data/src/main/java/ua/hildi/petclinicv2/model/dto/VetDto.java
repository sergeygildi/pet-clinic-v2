package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import ua.hildi.petclinicv2.model.Speciality;
import ua.hildi.petclinicv2.model.Vet;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link Vet} entity
 */
@Data
public class VetDto implements Serializable {
    @NotNull
    private final Long id;
    @NotEmpty
    @Min(7)
    @Max(15)
    private final String firstName;
    @NotEmpty
    @Min(7)
    @Max(15)
    private final String lastName;
    private final Set<Speciality> specialities;
}