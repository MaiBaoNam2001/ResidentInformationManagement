package com.citynow.residentinformationmanagement.dto.request;

import com.citynow.residentinformationmanagement.common.constant.RegexConst;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
public class ResidentAddRequest implements Serializable {
    @NotBlank(message = "{resident.name.blankErr}")
    private String name;
    @NotNull(message = "{resident.dob.nullErr}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dob;
    @NotBlank(message = "{resident.gender.blankErr}")
    private String gender;
    @Pattern(regexp = RegexConst.PHONE_NUMBER, message = "{resident.phone.regexpErr}")
    private String phone;
    @Pattern(regexp = RegexConst.EMAIL_SIMPLE, message = "{resident.email.regexpErr}")
    private String email;
    @NotBlank(message = "{resident.address.blankErr}")
    private String address;
}