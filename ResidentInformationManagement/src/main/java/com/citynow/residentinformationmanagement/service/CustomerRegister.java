package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRegister extends
    IService<CustomerRegister.Input, CustomerRegister.Output> {

  @Data
  class Input {

    private List<Customer> customers;

    @Data
    public static class Customer {

      private String id;
      private String name;
      private LocalDate dateOfBirth;
      private String gender;
      private String phone;
      private String email;
      private String address;
      private String type;
      private String identityCard;
      private LocalDate registerDate;
      private String projectId;
      private String buildingId;
      private String floorId;
      private String apartmentId;
      private String parkingAreaId;
      private boolean host;
      private boolean residentCard;
      private boolean motorbikeCard;
      private boolean carCard;
      private String apartmentRegisterId;
      private boolean deleted;
    }
  }

  @Data
  class Output {

    private List<Customer> customers;

    @Data
    public static class Customer {

      private String id;
      private String name;
      private LocalDate dateOfBirth;
      private String gender;
      private String phone;
      private String email;
      private String address;
      private String type;
      private String identityCard;
      private LocalDate registerDate;
      private String projectId;
      private String buildingId;
      private String floorId;
      private String apartmentId;
      private String parkingAreaId;
      private boolean host;
      private boolean residentCard;
      private boolean motorbikeCard;
      private boolean carCard;
      private String apartmentRegisterId;
      private boolean deleted;
    }
  }
}
