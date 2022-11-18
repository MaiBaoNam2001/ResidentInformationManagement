package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface CustomerImportExcelData extends
    IService<CustomerImportExcelData.Input, CustomerImportExcelData.Output> {

  @Data
  class Input {

    private MultipartFile multipartFile;
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
    }
  }
}
