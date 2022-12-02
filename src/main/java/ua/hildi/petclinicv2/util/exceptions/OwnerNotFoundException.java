package ua.hildi.petclinicv2.util.exceptions;

public class OwnerNotFoundException extends NotFoundException {
    public OwnerNotFoundException() {
        super("Owner with this Id is not found.");
    }

}
