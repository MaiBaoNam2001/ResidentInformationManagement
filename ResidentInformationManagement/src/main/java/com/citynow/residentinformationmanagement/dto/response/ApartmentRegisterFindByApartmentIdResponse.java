package com.citynow.residentinformationmanagement.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ApartmentRegisterFindByApartmentIdResponse implements Serializable {
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
