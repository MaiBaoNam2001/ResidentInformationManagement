package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.util.List;

public interface ApartmentFindByFloorId extends
    IService<ApartmentFindByFloorId.Input, ApartmentFindByFloorId.Output> {

  @Data
  class Input {

    private String floorId;
  }

  @Data
  class Output {

    private List<Apartment> apartments;

    @Data
    public static class Apartment {

      private String id;
      private String name;
      private String floor_id;
    }
  }
}
