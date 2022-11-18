package com.citynow.residentinformationmanagement.mapper;

import com.citynow.residentinformationmanagement.common.util.UUIDUtils;
import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.Customer;
import com.citynow.residentinformationmanagement.repository.ApartmentRepository;
import com.citynow.residentinformationmanagement.repository.CustomerRepository;
import com.citynow.residentinformationmanagement.service.ApartmentRegisterFindByApartmentId;
import com.citynow.residentinformationmanagement.service.CustomerRegister;
import com.citynow.residentinformationmanagement.service.CustomerRegister.Output;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApartmentRegisterMapper {

  private final CustomerRepository customerRepository;
  private final ApartmentRepository apartmentRepository;

  public ApartmentRegisterFindByApartmentId.Output.ApartmentRegister toApartmentRegisterFindByApartmentIdOutput(
      ApartmentRegister apartmentRegister) {
    ApartmentRegisterFindByApartmentId.Output.ApartmentRegister outputApartmentRegister = new ApartmentRegisterFindByApartmentId.Output.ApartmentRegister();
    outputApartmentRegister.setId(apartmentRegister.getCustomer().getId());
    outputApartmentRegister.setName(apartmentRegister.getCustomer().getName());
    outputApartmentRegister.setDateOfBirth(apartmentRegister.getCustomer().getDateOfBirth());
    outputApartmentRegister.setGender(apartmentRegister.getCustomer().getGender());
    outputApartmentRegister.setPhone(apartmentRegister.getCustomer().getPhone());
    outputApartmentRegister.setEmail(apartmentRegister.getCustomer().getEmail());
    outputApartmentRegister.setAddress(apartmentRegister.getCustomer().getAddress());
    outputApartmentRegister.setIdentityCard(apartmentRegister.getCustomer().getIdentityCard());
    outputApartmentRegister.setType(apartmentRegister.getCustomer().getType());
    outputApartmentRegister.setApartmentRegisterId(apartmentRegister.getId());
    outputApartmentRegister.setResidentCard(apartmentRegister.getResidentCard());
    outputApartmentRegister.setMotorbikeCard(apartmentRegister.getMotorbikeCard());
    outputApartmentRegister.setCarCard(apartmentRegister.getCarCard());
    outputApartmentRegister.setHost(apartmentRegister.getIsHost());
    outputApartmentRegister.setRegisterDate(apartmentRegister.getRegisterDate());
    outputApartmentRegister.setDeleted(apartmentRegister.getCustomer().getIsDeleted());
    return outputApartmentRegister;
  }

  public ApartmentRegister toApartmentRegister(CustomerRegister.Input.Customer inputCustomer) {
    Customer customer = new Customer();
    customer.setId(inputCustomer.getId());
    customer.setName(inputCustomer.getName());
    customer.setDateOfBirth(inputCustomer.getDateOfBirth());
    customer.setGender(inputCustomer.getGender());
    customer.setPhone(inputCustomer.getPhone());
    customer.setEmail(inputCustomer.getEmail());
    customer.setAddress(inputCustomer.getAddress());
    customer.setType(inputCustomer.getType());
    customer.setIdentityCard(inputCustomer.getIdentityCard());
    customer.setIsDeleted(inputCustomer.isDeleted());
    ApartmentRegister apartmentRegister = new ApartmentRegister();
    apartmentRegister.setId(!Objects.equals(inputCustomer.getApartmentRegisterId(), "")
        ? inputCustomer.getApartmentRegisterId() : UUIDUtils.getUUID());
    apartmentRegister.setCustomer(customerRepository.save(customer));
    apartmentRegister.setApartment(
        apartmentRepository.findById(inputCustomer.getApartmentId()).orElseThrow());
    apartmentRegister.setIsHost(inputCustomer.isHost());
    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonFactory jsonFactory = mapper.getFactory();
      String residentCardJsonString = "{\"active\": %b, \"project\": {\"id\": \"%s\", \"range\": {\"floor\": {\"id\": \"%s\", \"controls\": []}, \"building\": {\"id\": \"%s\", \"controls\": []}, \"apartment\": {\"id\": \"%s\", \"controls\": []}}}}";
      JsonParser residentCardJsonParser = jsonFactory.createParser(
          String.format(residentCardJsonString, inputCustomer.isResidentCard(),
              inputCustomer.getProjectId(), inputCustomer.getFloorId(),
              inputCustomer.getBuildingId(), inputCustomer.getApartmentId()));
      JsonNode residentCardJsonNode = mapper.readTree(residentCardJsonParser);
      String motorbikeCardJsonString = "{\"active\": %b, \"project\": {\"id\": \"%s\", \"range\": {\"parking_area\": {\"id\": \"%s\", \"controls\": []}}}}";
      JsonParser motorbikeCardJsonParser = jsonFactory.createParser(
          String.format(motorbikeCardJsonString, inputCustomer.isMotorbikeCard(),
              inputCustomer.getProjectId(), inputCustomer.getParkingAreaId()));
      JsonNode motorbikeCardJsonNode = mapper.readTree(motorbikeCardJsonParser);
      String carCardJsonString = "{\"active\": %b, \"project\": {\"id\": \"%s\", \"range\": {\"parking_area\": {\"id\": \"%s\", \"controls\": []}}}}";
      JsonParser carCardJsonParser = jsonFactory.createParser(
          String.format(carCardJsonString, inputCustomer.isCarCard(), inputCustomer.getProjectId(),
              inputCustomer.getParkingAreaId()));
      JsonNode carCardJsonNode = mapper.readTree(carCardJsonParser);
      apartmentRegister.setResidentCard(residentCardJsonNode);
      apartmentRegister.setMotorbikeCard(motorbikeCardJsonNode);
      apartmentRegister.setCarCard(carCardJsonNode);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    apartmentRegister.setRegisterDate(inputCustomer.getRegisterDate());
    return apartmentRegister;
  }

  public CustomerRegister.Output.Customer toCustomerRegisterOutput(
      ApartmentRegister apartmentRegister) {
    CustomerRegister.Output.Customer outputCustomer = new Output.Customer();
    outputCustomer.setId(apartmentRegister.getCustomer().getId());
    outputCustomer.setName(apartmentRegister.getCustomer().getName());
    outputCustomer.setDateOfBirth(apartmentRegister.getCustomer().getDateOfBirth());
    outputCustomer.setGender(apartmentRegister.getCustomer().getGender());
    outputCustomer.setPhone(apartmentRegister.getCustomer().getPhone());
    outputCustomer.setEmail(apartmentRegister.getCustomer().getEmail());
    outputCustomer.setAddress(apartmentRegister.getCustomer().getAddress());
    outputCustomer.setType(apartmentRegister.getCustomer().getType());
    outputCustomer.setIdentityCard(apartmentRegister.getCustomer().getIdentityCard());
    outputCustomer.setRegisterDate(apartmentRegister.getRegisterDate());
    outputCustomer.setProjectId(
        apartmentRegister.getResidentCard().get("project").get("id").asText());
    outputCustomer.setBuildingId(
        apartmentRegister.getResidentCard().get("project").get("range").get("building").get("id")
            .asText());
    outputCustomer.setFloorId(
        apartmentRegister.getResidentCard().get("project").get("range").get("floor").get("id")
            .asText());
    outputCustomer.setApartmentId(
        apartmentRegister.getResidentCard().get("project").get("range").get("apartment").get("id")
            .asText());
    outputCustomer.setParkingAreaId(
        apartmentRegister.getMotorbikeCard().get("project").get("range").get("parking_area")
            .get("id").asText());
    outputCustomer.setHost(apartmentRegister.getIsHost());
    outputCustomer.setResidentCard(apartmentRegister.getResidentCard().get("active").asBoolean());
    outputCustomer.setMotorbikeCard(apartmentRegister.getMotorbikeCard().get("active").asBoolean());
    outputCustomer.setCarCard(apartmentRegister.getCarCard().get("active").asBoolean());
    outputCustomer.setApartmentRegisterId(apartmentRegister.getId());
    outputCustomer.setDeleted(apartmentRegister.getCustomer().getIsDeleted());
    return outputCustomer;
  }
}
