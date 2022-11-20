package ua.hildi.petclinicv2.model.dto;

import lombok.Data;
import ua.hildi.petclinicv2.model.Pet;

import java.io.Serializable;
import java.util.Set;

@Data
public class OwnerDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String telephone;
    private final Set<Pet> pets;
}