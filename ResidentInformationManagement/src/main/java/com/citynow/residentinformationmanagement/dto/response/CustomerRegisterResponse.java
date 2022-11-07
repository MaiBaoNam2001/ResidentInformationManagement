package com.citynow.residentinformationmanagement.dto.response;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRegisterResponse {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String type;
    private String identityCard;
    private LocalDate registerDate;
    private String projectId;
    private String buildingId;
    private String floorId;
    private String apartmentId;
    private String parkingAreaId;
    private boolean host;
    private boolean residentCard;
    private boolean motorbikeCard;
    private boolean carCard;
    private String apartmentRegisterId;
    private boolean deleted;
}
