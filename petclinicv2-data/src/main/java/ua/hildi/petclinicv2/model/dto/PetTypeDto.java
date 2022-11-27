package ua.hildi.petclinicv2.model.dto;

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
public class PetTypeDto implements Serializable {
    @NotNull
    private final Long id;
    @NotBlank
    @Min(7)
    @Max(15)
    private final String name;
}