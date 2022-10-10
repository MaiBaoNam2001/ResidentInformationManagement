package com.mbn.residentinformationmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mbn.residentinformationmanagement.common.constant.RegexConst;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Resident {
    {
        this.id = StringUtils.left(String.valueOf(UUID.randomUUID()), 8);
    }

    @Id
    private String id;
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
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
}
