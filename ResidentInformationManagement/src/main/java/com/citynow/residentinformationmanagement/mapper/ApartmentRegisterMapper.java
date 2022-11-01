package com.citynow.residentinformationmanagement.mapper;

import com.citynow.residentinformationmanagement.common.util.UUIDUtils;
import com.citynow.residentinformationmanagement.dto.response.ApartmentRegisterFindByApartmentIdResponse;
import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.Customer;
import com.citynow.residentinformationmanagement.repository.ApartmentRepository;
import com.citynow.residentinformationmanagement.repository.CustomerRepository;
import com.citynow.residentinformationmanagement.service.ApartmentRegisterFindByApartmentId;
import com.citynow.residentinformationmanagement.service.CustomerRegister;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApartmentRegisterMapper {
    private final CustomerRepository customerRepository;
    private final ApartmentRepository apartmentRepository;
    private final UUIDUtils uuidUtils;

    public ApartmentRegisterFindByApartmentId.Output toApartmentRegisterFindByApartmentIdOutput(ApartmentRegister apartmentRegister) {
        ApartmentRegisterFindByApartmentId.Output output = new ApartmentRegisterFindByApartmentId.Output();
        output.setId(apartmentRegister.getCustomer().getId());
        output.setName(apartmentRegister.getCustomer().getName());
        output.setDateOfBirth(apartmentRegister.getCustomer().getDateOfBirth());
        output.setGender(apartmentRegister.getCustomer().getGender());
        output.setPhone(apartmentRegister.getCustomer().getPhone());
        output.setEmail(apartmentRegister.getCustomer().getEmail());
        output.setAddress(apartmentRegister.getCustomer().getAddress());
        output.setIdentityCard(apartmentRegister.getCustomer().getIdentityCard());
        output.setType(apartmentRegister.getCustomer().getType());
        output.setApartmentRegisterId(apartmentRegister.getId());
        output.setResidentCard(apartmentRegister.getResidentCard());
        output.setMotorbikeCard(apartmentRegister.getMotorbikeCard());
        output.setCarCard(apartmentRegister.getCarCard());
        output.setHost(apartmentRegister.getIsHost());
        output.setRegisterDate(apartmentRegister.getRegisterDate());
        return output;
    }

    public ApartmentRegister toApartmentRegister(CustomerRegister.Input input) {
        Customer customer = new Customer();
        customer.setId(input.getId());
        customer.setName(input.getName());
        customer.setDateOfBirth(input.getDateOfBirth());
        customer.setGender(input.getGender());
        customer.setPhone(input.getPhone());
        customer.setEmail(input.getEmail());
        customer.setAddress(input.getAddress());
        customer.setType(input.getType());
        customer.setIdentityCard(input.getIdentityCard());
        ApartmentRegister apartmentRegister = new ApartmentRegister();
        apartmentRegister.setId(input.getApartmentRegisterId() != "" ? input.getApartmentRegisterId() : uuidUtils.getUUID());
        apartmentRegister.setCustomer(customerRepository.save(customer));
        apartmentRegister.setApartment(apartmentRepository.findById(input.getApartmentId()).orElseThrow());
        apartmentRegister.setIsHost(input.isHost());
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory jsonFactory = mapper.getFactory();
            String residentCardJsonString = "{\"active\": %b, \"project\": {\"id\": \"%s\", \"range\": {\"floor\": {\"id\": \"%s\", \"controls\": []}, \"building\": {\"id\": \"%s\", \"controls\": []}, \"apartment\": {\"id\": \"%s\", \"controls\": []}}}}";
            JsonParser residentCardJsonParser = jsonFactory.createParser(String.format(residentCardJsonString, input.isResidentCard(), input.getProjectId(), input.getFloorId(), input.getBuildingId(), input.getApartmentId()));
            JsonNode residentCardJsonNode = mapper.readTree(residentCardJsonParser);
            String motorbikeCardJsonString = "{\"active\": %b, \"project\": {\"id\": \"%s\", \"range\": {\"parking_area\": {\"id\": \"%s\", \"controls\": []}}}}";
            JsonParser motorbikeCardJsonParser = jsonFactory.createParser(String.format(motorbikeCardJsonString, input.isMotorbikeCard(), input.getProjectId(), input.getParkingAreaId()));
            JsonNode motorbikeCardJsonNode = mapper.readTree(motorbikeCardJsonParser);
            String carCardJsonString = "{\"active\": %b, \"project\": {\"id\": \"%s\", \"range\": {\"parking_area\": {\"id\": \"%s\", \"controls\": []}}}}";
            JsonParser carCardJsonParser = jsonFactory.createParser(String.format(carCardJsonString, input.isCarCard(), input.getProjectId(), input.getParkingAreaId()));
            JsonNode carCardJsonNode = mapper.readTree(carCardJsonParser);
            apartmentRegister.setResidentCard(residentCardJsonNode);
            apartmentRegister.setMotorbikeCard(motorbikeCardJsonNode);
            apartmentRegister.setCarCard(carCardJsonNode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        apartmentRegister.setRegisterDate(input.getRegisterDate());
        return apartmentRegister;
    }
}
