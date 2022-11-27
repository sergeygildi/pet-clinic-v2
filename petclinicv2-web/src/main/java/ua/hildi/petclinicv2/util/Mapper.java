package ua.hildi.petclinicv2.util;

import ua.hildi.petclinicv2.model.*;
import ua.hildi.petclinicv2.model.dto.*;

public class Mapper {

    public OwnerDto toOwnerDto(Owner owner) {
        return new OwnerDto(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getAddress(),
                owner.getCity(),
                owner.getTelephone(),
                owner.getPets()
        );
    }

    public Owner toOwner(OwnerDto ownerDto) {
        return Owner.builder()
                .id(ownerDto.getId())
                .firstName(ownerDto.getFirstName())
                .lastName(ownerDto.getLastName())
                .address(ownerDto.getAddress())
                .city(ownerDto.getCity())
                .telephone(ownerDto.getTelephone())
                .pets(ownerDto.getPets())
                .build();
    }

    public PetTypeDto toPetTypesDto(PetType petType) {
        return new PetTypeDto(petType.getId(), petType.getName());
    }

    public VisitDto toVisitDto(Visit visit) {
        return new VisitDto(visit.getId(), visit.getDate(), visit.getDescription(), visit.getPet());
    }

    public Pet toPet(PetDto petDto) {
        return Pet.builder()
                .id(petDto.getId())
                .name(petDto.getName())
                .petType(petDto.getPetType())
                .visits(petDto.getVisits())
                .owner(petDto.getOwner())
                .birthDate(petDto.getBirthDate())
                .build();
    }

    public Visit toVisit(VisitDto visitDto) {
        return Visit.builder()
                .id(visitDto.getId())
                .date(visitDto.getDate())
                .description(visitDto.getDescription())
                .pet(visitDto.getPet())
                .build();
    }

    public VetDto toVet(Vet vet) {
        return new VetDto(vet.getId(), vet.getFirstName(), vet.getFirstName(), vet.getSpecialities());
    }
}
