package com.citynow.residentinformationmanagement.dto.request;

import com.citynow.residentinformationmanagement.common.constant.RegexConst;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CustomerUpdateRequest implements Serializable {
    @NotBlank(message = "{customerUpdate.id.blankErr}")
    private String id;
    @NotBlank(message = "{customerUpdate.name.blankErr}")
    private String name;
    @NotNull(message = "{customerUpdate.dateOfBirth.nullErr}")
    private LocalDate dateOfBirth;
    @NotBlank(message = "{customerUpdate.gender.blankErr}")
    private String gender;
    @Pattern(regexp = RegexConst.PHONE_NUMBER, message = "{customerUpdate.phone.patternErr}")
    private String phone;
    @Pattern(regexp = RegexConst.EMAIL_SIMPLE, message = "{customerUpdate.email.patternErr}")
    private String email;
    @NotBlank(message = "{customerUpdate.address.blankErr}")
    private String address;
    @NotBlank(message = "{customerUpdate.type.blankErr}")
    private String type;
    @NotBlank(message = "{customerUpdate.identityCard.blankErr}")
    private String identityCard;
    @NotNull(message = "{customerUpdate.registerDate.nullErr}")
    private LocalDate registerDate;
}
