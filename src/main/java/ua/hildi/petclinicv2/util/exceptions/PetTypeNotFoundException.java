package ua.hildi.petclinicv2.util.exceptions;

public class PetTypeNotFoundException extends NotFoundException {
    public PetTypeNotFoundException() {
        super("PetType with this Id is not found.");
    }
}
