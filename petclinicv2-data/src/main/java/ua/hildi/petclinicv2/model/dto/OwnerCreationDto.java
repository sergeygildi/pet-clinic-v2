package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import ua.hildi.petclinicv2.model.Owner;

import java.io.Serializable;

/**
 * A DTO for the {@link Owner} entity
 */
@Data
public class OwnerCreationDto implements Serializable {
    private final String firstName;
    private final String lastName;
}