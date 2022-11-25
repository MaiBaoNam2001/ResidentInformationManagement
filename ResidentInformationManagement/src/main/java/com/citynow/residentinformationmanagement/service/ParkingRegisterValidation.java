package com.citynow.residentinformationmanagement.service;

import com.citynow.residentinformationmanagement.service.template.IService;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

public interface ParkingRegisterValidation extends
    IService<ParkingRegisterValidation.Input, ParkingRegisterValidation.Output> {

  @Data
  class Input {

    @NotBlank(message = "{parkingRegister.projectId.blankErr}")
    private String projectId;
    @NotBlank(message = "{parkingRegister.buildingId.blankErr}")
    private String buildingId;
    @NotBlank(message = "{parkingRegister.parkingAreaId.blankErr}")
    private String parkingAreaId;
    @NotBlank(message = "{parkingRegister.identityCard.blankErr}")
    private String identityCard;
    @Size(min = 8, max = 8, message = "{parkingRegister.licensePlate.sizeErr}")
    private String licensePlate;
    @NotBlank(message = "{parkingRegister.brandName.blankErr}")
    private String brandName;
    @NotBlank(message = "{parkingRegister.color.blankErr}")
    private String color;
    @NotBlank(message = "{parkingRegister.vehicleType.blankErr}")
    private String vehicleType;
    @NotNull(message = "{parkingRegister.registerDate.nullErr}")
    private LocalDate registerDate;
    @NotNull(message = "{parkingRegister.parkingType.nullErr}")
    private int parkingTypeId;
  }

  @Data
  class Output {

    private int statusCode;
    private Object result;
  }
}
