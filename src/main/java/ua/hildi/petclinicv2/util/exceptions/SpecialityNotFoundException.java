package ua.hildi.petclinicv2.util.exceptions;

public class SpecialityNotFoundException extends NotFoundException {
    public SpecialityNotFoundException() {
        super("Speciality with this Id is not found.");
    }

}
