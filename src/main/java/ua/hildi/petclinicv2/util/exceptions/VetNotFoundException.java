package ua.hildi.petclinicv2.util.exceptions;

public class VetNotFoundException extends NotFoundException {
    public VetNotFoundException() {
        super("Vet with this Id is not found.");
    }

}
