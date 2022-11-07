package com.citynow.residentinformationmanagement.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CustomerUpdateResponse implements Serializable {
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
}
