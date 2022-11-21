package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.mapper.ApartmentRegisterMapper;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.service.CustomerRegister;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerRegisterServiceImpl extends
    BaseService<CustomerRegister.Input, CustomerRegister.Output> implements CustomerRegister {

  private final ApartmentRegisterRepository apartmentRegisterRepository;
  private final ApartmentRegisterMapper apartmentRegisterMapper;


  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    List<ApartmentRegister> apartmentRegisters = ListUtils.emptyIfNull(input.getCustomers())
        .stream().map(apartmentRegisterMapper::toApartmentRegister).collect(Collectors.toList());
    Output output = new Output();
    output.setCustomers(
        ListUtils.emptyIfNull(apartmentRegisterRepository.saveAll(apartmentRegisters)).stream()
            .map(apartmentRegisterMapper::toCustomerRegisterOutput).collect(Collectors.toList()));
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
