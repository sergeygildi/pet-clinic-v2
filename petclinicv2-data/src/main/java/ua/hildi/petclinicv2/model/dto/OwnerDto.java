package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.Pet;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link Owner} entity
 */
@Data
public class OwnerDto implements Serializable {
    @NotNull
    private final Long id;
    @NotBlank
    @Min(7)
    @Max(15)
    private final String firstName;
    @NotBlank
    @Min(7)
    @Max(15)
    private final String lastName;
    private final String address;
    @NotEmpty
    private final String city;
    private final String telephone;
    private final Set<Pet> pets;
}