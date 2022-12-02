package ua.hildi.petclinicv2.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.Visit;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Visit} entity
 */
@Data
@Builder
public class VisitDto implements Serializable {
    @NotNull
    private final Long id;
    @DateTimeFormat
    private final LocalDate date;
    @Min(value = 0, message = "Name should be grader than 0 symbols")
    @Max(value = 255, message = "Name should be less than 255 symbols")
    private final String description;
    @NotNull
    private final Pet pet;
}