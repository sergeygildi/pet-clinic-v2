package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.model.dto.PetDto;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class VisitDto implements Serializable {
    private final LocalDate date;
    private final String description;
    private final Pet pet;
}