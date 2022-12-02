package ua.hildi.petclinicv2.util.exceptions;

public class VisitNotFoundException extends NotFoundException {
    public VisitNotFoundException() {
        super("Visit with this Id is not found.");
    }
}
