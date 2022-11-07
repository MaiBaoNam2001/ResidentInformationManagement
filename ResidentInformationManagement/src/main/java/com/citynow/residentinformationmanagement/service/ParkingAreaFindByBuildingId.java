package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface ParkingAreaFindByBuildingId extends IService<ParkingAreaFindByBuildingId.Input, List<ParkingAreaFindByBuildingId.Output>> {
    @Data
    class Input {
        private String buildingId;
    }

    @Data
    class Output {
        private String id;
        private String name;
    }
}
