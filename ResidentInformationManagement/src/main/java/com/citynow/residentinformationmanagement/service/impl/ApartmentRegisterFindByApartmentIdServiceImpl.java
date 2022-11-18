package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.Customer;
import com.citynow.residentinformationmanagement.mapper.ApartmentRegisterMapper;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.service.ApartmentRegisterFindByApartmentId;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentRegisterFindByApartmentIdServiceImpl extends
    BaseService<ApartmentRegisterFindByApartmentId.Input, ApartmentRegisterFindByApartmentId.Output> implements
    ApartmentRegisterFindByApartmentId {

  private final ApartmentRegisterRepository apartmentRegisterRepository;
  private final ApartmentRegisterMapper apartmentRegisterMapper;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    List<ApartmentRegister> apartmentRegisters = apartmentRegisterRepository.findByApartmentId(
        input.getApartmentId());
    Output output = new Output();
    List<Output.ApartmentRegister> outputApartmentRegisterList = apartmentRegisters.stream()
        .map(apartmentRegisterMapper::toApartmentRegisterFindByApartmentIdOutput)
        .collect(Collectors.toList());
    outputApartmentRegisterList = outputApartmentRegisterList.stream().filter(
            Predicate.not(ApartmentRegisterFindByApartmentId.Output.ApartmentRegister::isDeleted))
        .sorted(Comparator.comparing(
            ApartmentRegisterFindByApartmentId.Output.ApartmentRegister::isHost).reversed())
        .collect(Collectors.toList());
    output.setApartmentRegisters(outputApartmentRegisterList);
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
