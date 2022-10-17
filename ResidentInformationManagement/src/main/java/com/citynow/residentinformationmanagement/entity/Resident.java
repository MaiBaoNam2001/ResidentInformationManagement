package com.citynow.residentinformationmanagement.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table
public class Resident {
    {
        this.id = StringUtils.left(String.valueOf(UUID.randomUUID()), 8);
    }

    @Id
    private String id;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String email;
    private String address;
}
