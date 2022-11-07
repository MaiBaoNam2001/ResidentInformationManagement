package com.citynow.residentinformationmanagement.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerExcelData {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String identityCard;
}
