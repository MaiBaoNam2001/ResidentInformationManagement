package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface BuildingFindByProjectId extends IService<BuildingFindByProjectId.Input, List<BuildingFindByProjectId.Output>> {
    @Data
    class Input {
        private String projectId;
    }

    @Data
    class Output {
        private String id;
        private String name;
        private String project_id;
    }
}
