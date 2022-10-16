package com.citynow.residentinformationmanagement.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResidentAddResponse implements Serializable {
    private String id;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String email;
    private String address;
}
