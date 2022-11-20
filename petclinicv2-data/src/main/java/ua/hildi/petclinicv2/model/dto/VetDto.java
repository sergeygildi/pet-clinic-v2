package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import ua.hildi.petclinicv2.model.Speciality;

import java.io.Serializable;
import java.util.Set;

@Data
public class VetDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final Set<Speciality> specialities;
}