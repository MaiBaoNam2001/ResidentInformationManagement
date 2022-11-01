package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface FloorFindByBuildingId extends IService<FloorFindByBuildingId.Input, List<FloorFindByBuildingId.Output>> {
    @Data
    class Input {
        private String buildingId;
    }

    @Data
    class Output {
        private String id;
        private int number;
        private String building_id;
    }
}
