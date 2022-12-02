package ua.hildi.petclinicv2.model.dto;

import lombok.Builder;
import lombok.Data;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.Pet;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/**
 * A DTO for the {@link Owner} entity
 */
@Data
@Builder
public class OwnerDto implements Serializable {
    @NotNull
    private Long id;
    @NotNull
    @Min(value = 0, message = "Name should be grader than 0 symbols")
    @Max(value = 15, message = "Name should be less than 15 symbols")
    private final String firstName;
    @NotNull
    @Min(value = 0, message = "Last name should be grader than 0 symbols")
    @Max(value = 15, message = "Last name should be less than 15 symbols")
    private final String lastName;
    private final String address;
    private final String city;
    private final String telephone;
    @NotNull
    private final Set<Pet> pets;
}