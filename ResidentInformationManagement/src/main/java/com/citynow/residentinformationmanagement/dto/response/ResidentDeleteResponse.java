package com.citynow.residentinformationmanagement.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResidentDeleteResponse {
    private String id;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String email;
    private String address;
}
