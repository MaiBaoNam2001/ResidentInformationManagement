package com.mbn.residentinformationmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mbn.residentinformationmanagement.common.constant.RegexConst;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class User {
    {
        this.id = StringUtils.left(String.valueOf(UUID.randomUUID()), 8);
    }

    @Id
    private String id;
    @Pattern(regexp = RegexConst.USERNAME)
    private String username;
    @Pattern(regexp = RegexConst.PASSWORD)
    private String password;
    @NotNull
    @Column(name = "created_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdDate;
    @OneToOne(mappedBy = "user")
    private Resident resident;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
