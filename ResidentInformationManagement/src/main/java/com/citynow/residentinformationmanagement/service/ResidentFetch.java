package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.Date;
import java.util.List;

public interface ResidentFetch extends IService<ResidentFetch.Input, List<ResidentFetch.Output>> {
    @Data
    class Input {
        private int page;
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
