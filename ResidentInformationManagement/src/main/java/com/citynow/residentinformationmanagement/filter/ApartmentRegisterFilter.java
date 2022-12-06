package com.citynow.residentinformationmanagement.filter;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class ApartmentRegisterFilter {

  private static final String MOTORBIKE = "xe máy";
  private static final String CAR = "xe hơi";

  public boolean filterByParkingAreaIdAndLicensePlate(ApartmentRegister apartmentRegister,
      String parkingAreaId, String licensePlate) {
    final String parkingAreaIdByMotorbikeCard = apartmentRegister.getMotorbikeCard().get("project")
        .get("range").get("parking_area").get("id").asText();
    final String parkingAreaIdByCarCard = apartmentRegister.getCarCard().get("project").get("range")
        .get("parking_area").get("id").asText();
    final boolean isMotorbikeCardActive = apartmentRegister.getMotorbikeCard().get("active")
        .asBoolean();
    final boolean isCarCardActive = apartmentRegister.getCarCard().get("active").asBoolean();
    final boolean isMotorbikeCardRegisteredByLicensePlate = apartmentRegister.getCustomer()
        .getParkingRegisters().stream().anyMatch(
            parkingRegister -> parkingRegister.getLicensePlate().equals(licensePlate)
                && parkingRegister.getVehicleType().equalsIgnoreCase(MOTORBIKE));
    final boolean isCarCardRegisteredByLicensePlate = apartmentRegister.getCustomer()
        .getParkingRegisters().stream().anyMatch(
            parkingRegister -> parkingRegister.getLicensePlate().equals(licensePlate)
                && parkingRegister.getVehicleType().equalsIgnoreCase(CAR));
    final boolean isParkingAreaIdExistedByMotorbikeCard = Objects.equals(
        parkingAreaIdByMotorbikeCard, parkingAreaId);
    final boolean isParkingAreaIdExistedByCarCard = Objects.equals(parkingAreaIdByCarCard,
        parkingAreaId);
    return (isParkingAreaIdExistedByMotorbikeCard && isMotorbikeCardActive
        && isMotorbikeCardRegisteredByLicensePlate) || (isParkingAreaIdExistedByCarCard
        && isCarCardActive && isCarCardRegisteredByLicensePlate);
  }

  public boolean filterByParkingAreaId(ApartmentRegister apartmentRegister, String parkingAreaId) {
    final String parkingAreaIdByMotorbikeCard = apartmentRegister.getMotorbikeCard().get("project")
        .get("range").get("parking_area").get("id").asText();
    final String parkingAreaIdByCarCard = apartmentRegister.getCarCard().get("project").get("range")
        .get("parking_area").get("id").asText();
    final boolean isMotorbikeCardActive = apartmentRegister.getMotorbikeCard().get("active")
        .asBoolean();
    final boolean isCarCardActive = apartmentRegister.getCarCard().get("active").asBoolean();
    final boolean isParkingAreaIdExistedByMotorbikeCard = Objects.equals(
        parkingAreaIdByMotorbikeCard, parkingAreaId);
    final boolean isParkingAreaIdExistedByCarCard = Objects.equals(parkingAreaIdByCarCard,
        parkingAreaId);
    return (isParkingAreaIdExistedByMotorbikeCard && isMotorbikeCardActive) || (
        isParkingAreaIdExistedByCarCard && isCarCardActive);
  }
}
