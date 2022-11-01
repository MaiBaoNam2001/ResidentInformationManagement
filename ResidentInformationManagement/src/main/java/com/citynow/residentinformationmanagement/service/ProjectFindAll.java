package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface ProjectFindAll extends IService<ProjectFindAll.Input, List<ProjectFindAll.Output>> {
    class Input {

    }

    @Data
    class Output {
        private String id;
        private String name;
        private String area;
    }
}
