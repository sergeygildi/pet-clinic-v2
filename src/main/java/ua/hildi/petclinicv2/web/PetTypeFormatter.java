package ua.hildi.petclinicv2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import ua.hildi.petclinicv2.model.PetType;
import ua.hildi.petclinicv2.service.ClinicService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

public class PetTypeFormatter implements Formatter<PetType> {

    private ClinicService clinicService;

    @Autowired
    public PetTypeFormatter(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = this.clinicService.findPetTypes();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

}
