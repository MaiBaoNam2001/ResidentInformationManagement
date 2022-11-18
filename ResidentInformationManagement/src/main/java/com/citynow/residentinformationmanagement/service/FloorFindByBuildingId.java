package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface FloorFindByBuildingId extends
    IService<FloorFindByBuildingId.Input, FloorFindByBuildingId.Output> {

  @Data
  class Input {

    private String buildingId;
  }

  @Data
  class Output {

    private List<Floor> floors;

    @Data
    public static class Floor {

      private String id;
      private int number;
      private String building_id;
    }
  }
}
