package com.citynow.residentinformationmanagement.filter;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class ApartmentRegisterFilter {

  public static boolean filterByParkingAreaIdAndLicensePlate(ApartmentRegister apartmentRegister,
      String parkingAreaId, String licensePlate) {
    String parkingAreaIdByMotorbikeCard = apartmentRegister.getMotorbikeCard().get("project")
        .get("range").get("parking_area").get("id").asText();
    String parkingAreaIdByCarCard = apartmentRegister.getCarCard().get("project").get("range")
        .get("parking_area").get("id").asText();
    boolean isMotorbikeCardActive = apartmentRegister.getMotorbikeCard().get("active").asBoolean();
    boolean isCarCardActive = apartmentRegister.getCarCard().get("active").asBoolean();
    boolean isMotorbikeCardRegisteredByLicensePlate = apartmentRegister.getCustomer()
        .getParkingRegisters().stream().anyMatch(
            parkingRegister -> parkingRegister.getLicensePlate().equals(licensePlate)
                && parkingRegister.getVehicleType().equalsIgnoreCase("xe máy"));
    boolean isCarCardRegisteredByLicensePlate = apartmentRegister.getCustomer()
        .getParkingRegisters().stream().anyMatch(
            parkingRegister -> parkingRegister.getLicensePlate().equals(licensePlate)
                && parkingRegister.getVehicleType().equalsIgnoreCase("xe hơi"));
    return (Objects.equals(parkingAreaIdByMotorbikeCard, parkingAreaId) && isMotorbikeCardActive
        && isMotorbikeCardRegisteredByLicensePlate) || (
        Objects.equals(parkingAreaIdByCarCard, parkingAreaId) && isCarCardActive
            && isCarCardRegisteredByLicensePlate);
  }

  public static boolean filterByParkingAreaId(ApartmentRegister apartmentRegister,
      String parkingAreaId) {
    String parkingAreaIdByMotorbikeCard = apartmentRegister.getMotorbikeCard().get("project")
        .get("range").get("parking_area").get("id").asText();
    String parkingAreaIdByCarCard = apartmentRegister.getCarCard().get("project").get("range")
        .get("parking_area").get("id").asText();
    boolean isMotorbikeCardActive = apartmentRegister.getMotorbikeCard().get("active").asBoolean();
    boolean isCarCardActive = apartmentRegister.getCarCard().get("active").asBoolean();
    return (Objects.equals(parkingAreaIdByMotorbikeCard, parkingAreaId) && isMotorbikeCardActive)
        || (Objects.equals(parkingAreaIdByCarCard, parkingAreaId) && isCarCardActive);
  }
}
