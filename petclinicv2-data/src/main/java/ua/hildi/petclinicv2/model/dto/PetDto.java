package ua.hildi.petclinicv2.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PetDto implements Serializable {
    private final String name;
    private final LocalDate birthDate;
}