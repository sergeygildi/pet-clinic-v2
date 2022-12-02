package ua.hildi.petclinicv2.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ua.hildi.petclinicv2.model.PetType} entity
 */
@Data
@Builder
public class PetTypeDto implements Serializable {
    @NotNull
    private final Long id;
    @NotBlank
    @Min(value = 0, message = "Name should be grader than 0 symbols")
    @Max(value = 15, message = "Name should be less than 15 symbols")
    private final String name;
}