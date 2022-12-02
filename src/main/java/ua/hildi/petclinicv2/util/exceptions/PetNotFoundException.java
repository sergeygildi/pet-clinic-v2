package ua.hildi.petclinicv2.util.exceptions;

public class PetNotFoundException extends NotFoundException {
    public PetNotFoundException() {
        super("Pet with this Id is not found.");
    }
}
