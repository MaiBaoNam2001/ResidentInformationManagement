package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface ApartmentFindByFloorId extends IService<ApartmentFindByFloorId.Input, List<ApartmentFindByFloorId.Output>> {
    @Data
    class Input {
        private String floorId;
    }

    @Data
    class Output {
        private String id;
        private String name;
        private String floor_id;
    }
}
