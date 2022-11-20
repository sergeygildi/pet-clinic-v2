package ua.hildi.petclinicv2.model.dto;

import org.springframework.stereotype.Component;
import ua.hildi.petclinicv2.model.*;

@Component
public class Mapper {

    public OwnerDto toOwnerDto(Owner owner) {
        return new OwnerDto(owner.getFirstName(), owner.getLastName(), owner.getAddress(),
                owner.getCity(), owner.getTelephone(), owner.getPets());
    }

    public Owner toOwner(OwnerDto ownerDto) {
        return Owner.builder()
                .firstName(ownerDto.getFirstName())
                .lastName(ownerDto.getLastName())
                .address(ownerDto.getAddress())
                .city(ownerDto.getCity())
                .telephone(ownerDto.getTelephone())
                .pets(ownerDto.getPets())
                .build();
    }

    public PetTypeDto toPetTypesDto(PetType petType) {
        return new PetTypeDto(petType.getName());
    }

    public VisitDto toVisitDto(Visit visit) {
        return new VisitDto(visit.getDate(), visit.getDescription(), visit.getPet());
    }

    public Owner toOwner(OwnerCreationDto ownerDto) {
        return Owner.builder()
                .firstName(ownerDto.getFirstName())
                .lastName(ownerDto.getLastName())
                .build();
    }

    public Pet toPet(PetDto petDto) {
        return Pet.builder()
                .name(petDto.getName())
                .birthDate(petDto.getBirthDate())
                .build();
    }

    public Visit toVisit(VisitDto visitDto) {
        return Visit.builder()
                .date(visitDto.getDate())
                .description(visitDto.getDescription())
                .pet(visitDto.getPet())
                .build();
    }

    public VetDto toVet(Vet vet) {
        return new VetDto(vet.getFirstName(), vet.getFirstName(), vet.getSpecialities());
    }
}
