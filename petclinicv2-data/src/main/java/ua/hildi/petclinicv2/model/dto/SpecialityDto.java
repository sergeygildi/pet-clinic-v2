package ua.hildi.petclinicv2.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link ua.hildi.petclinicv2.model.Speciality} entity
 */
@Data
public class SpecialityDto implements Serializable {
    @NotNull
    private final Long id;

    private final String description;
}