package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.util.UUIDUtils;
import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.ParkingRegister;
import com.citynow.residentinformationmanagement.filter.ApartmentRegisterFilter;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.repository.CustomerRepository;
import com.citynow.residentinformationmanagement.repository.ParkingAreaRepository;
import com.citynow.residentinformationmanagement.repository.ParkingRegisterRepository;
import com.citynow.residentinformationmanagement.repository.ParkingTypeRepository;
import com.citynow.residentinformationmanagement.service.ParkingRegisterValidation;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingRegisterValidationServiceImpl extends
    BaseService<ParkingRegisterValidation.Input, ParkingRegisterValidation.Output> implements
    ParkingRegisterValidation {

  private final Validator validator;
  private final ParkingRegisterRepository parkingRegisterRepository;
  private final CustomerRepository customerRepository;
  private final ParkingAreaRepository parkingAreaRepository;
  private final ParkingTypeRepository parkingTypeRepository;
  private final ApartmentRegisterRepository apartmentRegisterRepository;
  private final ApartmentRegisterFilter apartmentRegisterFilter;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    Output output = new Output();
    Set<ConstraintViolation<Input>> constraintViolations = validator.validate(input);
    List<String> errorMessages = new ArrayList<>();
    if (!constraintViolations.isEmpty()) {
      for (ConstraintViolation<Input> constraintViolation : constraintViolations) {
        errorMessages.add(constraintViolation.getMessage());
      }
    }

    ParkingRegister parkingRegister = new ParkingRegister();
    parkingRegister.setId(UUIDUtils.getUUID());
    if (customerRepository.findByIdentityCard(input.getIdentityCard()).isPresent()) {
      parkingRegister.setCustomer(
          customerRepository.findByIdentityCard(input.getIdentityCard()).get());
    } else {
      errorMessages.add("The Identity Card field does not exist");
    }
    if (parkingAreaRepository.findById(input.getParkingAreaId()).isPresent()) {
      parkingRegister.setParkingArea(
          parkingAreaRepository.findById(input.getParkingAreaId()).get());
    } else {
      errorMessages.add("The Parking Area Id field does not exist");
    }

    if (!parkingRegisterRepository.existsByLicensePlate(input.getLicensePlate())) {
      parkingRegister.setLicensePlate(input.getLicensePlate());
    } else {
      errorMessages.add("The License Plate already exists");
    }

    parkingRegister.setBrandName(input.getBrandName());
    parkingRegister.setColor(input.getColor());
    parkingRegister.setVehicleType(input.getVehicleType());
    parkingRegister.setRegisterDate(input.getRegisterDate());
    if (parkingTypeRepository.findById((long) input.getParkingTypeId()).isPresent()) {
      parkingRegister.setParkingType(
          parkingTypeRepository.findById((long) input.getParkingTypeId()).get());
    } else {
      errorMessages.add("The Parking Type Id field does not exist");
    }

    List<ApartmentRegister> apartmentRegisters = apartmentRegisterRepository.findByIdentityCard(
        input.getIdentityCard());
    final boolean apartmentRegistersNonExistentByParkingAreaId = apartmentRegisters.stream()
        .noneMatch(
            apartmentRegister -> apartmentRegisterFilter.filterByParkingAreaId(apartmentRegister,
                input.getParkingAreaId()));
    if (apartmentRegistersNonExistentByParkingAreaId) {
      errorMessages.add("The Identity Card is not active");
    }

    if (errorMessages.isEmpty()) {
      parkingRegisterRepository.save(parkingRegister);
      output.setStatusCode(200);
      output.setResult(input);
      return output;
    }
    output.setStatusCode(500);
    output.setResult(errorMessages);
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
