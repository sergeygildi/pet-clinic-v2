package ua.hildi.petclinicv2.util;

import org.springframework.stereotype.Component;
import ua.hildi.petclinicv2.model.*;
import ua.hildi.petclinicv2.model.dto.*;

import java.util.List;

@Component
public class DTOConverter {

    public OwnerDto toOwnerDto(Owner owner) {
        return OwnerDto.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .city(owner.getCity())
                .address(owner.getAddress())
                .telephone(owner.getTelephone())
                .pets(owner.getPets())
                .build();
    }

    public List<OwnerDto> toOwnerDto(List<Owner> owners) {
        return owners.stream()
                .map(this::toOwnerDto)
                .toList();
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
        return PetTypeDto.builder()
                .id(petType.getId())
                .name(petType.getName())
                .build();
    }

    public VisitDto toVisitDto(Visit visit) {
        return VisitDto.builder()
                .id(visit.getId())
                .date(visit.getDate())
                .description(visit.getDescription())
                .pet(visit.getPet())
                .build();
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
        return VetDto.builder()
                .id(vet.getId())
                .firstName(vet.getFirstName())
                .lastName(vet.getLastName())
                .specialities(vet.getSpecialities())
                .build();
    }
}
