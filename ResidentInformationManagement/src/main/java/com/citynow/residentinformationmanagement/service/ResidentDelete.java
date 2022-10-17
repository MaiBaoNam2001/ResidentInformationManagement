package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.Date;

public interface ResidentDelete extends IService<ResidentDelete.Input, ResidentDelete.Output> {
    @Data
    class Input {
        private String id;
    }

    @Data
    class Output {
        private String id;
        private String name;
        private Date dob;
        private String gender;
        private String phone;
        private String email;
        private String address;
    }
}
