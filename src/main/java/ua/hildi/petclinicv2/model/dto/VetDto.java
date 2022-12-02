package ua.hildi.petclinicv2.model.dto;

import lombok.Builder;
import lombok.Data;
import ua.hildi.petclinicv2.model.Speciality;
import ua.hildi.petclinicv2.model.Vet;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link Vet} entity
 */
@Data
@Builder
public class VetDto implements Serializable {
    @NotNull
    private final Long id;
    @NotNull
    @Min(value = 0, message = "Name should be grader than 0 symbols")
    @Max(value = 15, message = "Name should be less than 15 symbols")
    private final String firstName;
    @NotNull
    @Min(value = 0, message = "Name should be grader than 0 symbols")
    @Max(value = 15, message = "Name should be less than 15 symbols")
    private final String lastName;

    private final Set<Speciality> specialities;
}