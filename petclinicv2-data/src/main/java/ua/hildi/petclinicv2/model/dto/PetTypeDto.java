package ua.hildi.petclinicv2.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PetTypeDto implements Serializable {
    private final String name;
}