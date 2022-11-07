package com.citynow.residentinformationmanagement.dto.request;

import com.citynow.residentinformationmanagement.common.constant.RegexConst;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CustomerRegisterRequest implements Serializable {
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
