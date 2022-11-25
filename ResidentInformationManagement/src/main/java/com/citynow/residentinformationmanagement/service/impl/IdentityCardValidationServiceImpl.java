package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.filter.ApartmentRegisterFilter;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.repository.CustomerRepository;
import com.citynow.residentinformationmanagement.repository.ParkingAreaRepository;
import com.citynow.residentinformationmanagement.service.IdentityCardValidation;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdentityCardValidationServiceImpl extends
    BaseService<IdentityCardValidation.Input, IdentityCardValidation.Output> implements
    IdentityCardValidation {

  private final CustomerRepository customerRepository;
  private final ParkingAreaRepository parkingAreaRepository;
  private final ApartmentRegisterRepository apartmentRegisterRepository;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    Output output = new Output();
    List<String> errorMessages = new ArrayList<>();
    if (!parkingAreaRepository.existsById(input.getParkingAreaId())) {
      errorMessages.add("The Parking Area does not exist");
    }
    if (!customerRepository.existsByIdentityCard(input.getIdentityCard())) {
      errorMessages.add("The Identity Card does not exist");
    }
    List<ApartmentRegister> apartmentRegisters = apartmentRegisterRepository.findByIdentityCard(
        input.getIdentityCard());
    if (apartmentRegisters.stream().noneMatch(
        apartmentRegister -> ApartmentRegisterFilter.filterByParkingAreaId(apartmentRegister,
            input.getParkingAreaId()))) {
      errorMessages.add("The Identity Card is not active");
    }
    if (!errorMessages.isEmpty()) {
      output.setStatusCode(500);
      output.setResult(errorMessages);
      return output;
    }
    output.setStatusCode(200);
    output.setResult(input);
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
