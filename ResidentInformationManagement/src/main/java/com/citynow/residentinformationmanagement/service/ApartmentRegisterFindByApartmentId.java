package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ApartmentRegisterFindByApartmentId extends IService<ApartmentRegisterFindByApartmentId.Input, List<ApartmentRegisterFindByApartmentId.Output>> {
    @Data
    class Input {
        private String apartmentId;
    }

    @Data
    class Output {
        private String id;
        private String name;
        private LocalDate dateOfBirth;
        private String gender;
        private String phone;
        private String email;
        private String address;
        private String identityCard;
        private String type;
        private String apartmentRegisterId;
        private JsonNode residentCard;
        private JsonNode motorbikeCard;
        private JsonNode carCard;
        private boolean isHost;
        private LocalDate registerDate;
        private boolean isDeleted;
    }
}
