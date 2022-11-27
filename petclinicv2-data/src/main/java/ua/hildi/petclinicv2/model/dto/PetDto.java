package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.model.PetType;
import ua.hildi.petclinicv2.model.Visit;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * A DTO for the {@link ua.hildi.petclinicv2.model.Pet} entity
 */
@Data
public class PetDto implements Serializable {
    @NotNull
    private final Long id;
    @NotBlank
    @Min(7)
    @Max(15)
    private final String name;
    @NotNull
    private final PetType petType;
    @NotNull
    private final Owner owner;
    @DateTimeFormat(pattern = "dd.mm.yy")
    private final LocalDate birthDate;
    private final Set<Visit> visits;
}