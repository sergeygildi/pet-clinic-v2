package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.Visit;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Visit} entity
 */
@Data
public class VisitDto implements Serializable {
    @NotNull
    private final Long id;
    @DateTimeFormat
    private final LocalDate date;
    private final String description;
    private final Pet pet;
}