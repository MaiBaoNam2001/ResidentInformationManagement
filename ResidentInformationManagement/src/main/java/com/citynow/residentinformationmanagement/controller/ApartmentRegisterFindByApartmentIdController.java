package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.ApartmentRegisterFindByApartmentIdResponse;
import com.citynow.residentinformationmanagement.service.ApartmentRegisterFindByApartmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApartmentRegisterFindByApartmentIdController {

  private final ApartmentRegisterFindByApartmentId apartmentRegisterFindByApartmentId;
  private final ModelConverter modelConverter;

  @GetMapping("/apartment_registers/{apartmentId}")
  public List<ApartmentRegisterFindByApartmentIdResponse> findCustomersByApartmentId(
      @PathVariable(value = "apartmentId") String apartmentId) {
    ApartmentRegisterFindByApartmentId.Input input = new ApartmentRegisterFindByApartmentId.Input();
    input.setApartmentId(apartmentId);
    return modelConverter.mapAllByIterator(
        apartmentRegisterFindByApartmentId.execute(input).getApartmentRegisters(),
        ApartmentRegisterFindByApartmentIdResponse.class);
  }
}
