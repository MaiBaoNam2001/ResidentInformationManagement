package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.common.util.UUIDUtils;
import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.Customer;
import com.citynow.residentinformationmanagement.mapper.ApartmentRegisterMapper;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import com.citynow.residentinformationmanagement.service.CustomerRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerRegisterServiceImpl extends BaseService<List<CustomerRegister.Input>, List<CustomerRegister.Output>> implements CustomerRegister {

    private final ApartmentRegisterRepository apartmentRegisterRepository;
    private final ModelConverter modelConverter;
    private final ApartmentRegisterMapper apartmentRegisterMapper;

    @Override
    protected void preExecute(List<Input> input) {

    }

    @Override
    protected List<Output> doExecute(List<Input> input) {
        List<ApartmentRegister> apartmentRegisters = input.stream().map(apartmentRegisterMapper::toApartmentRegister).collect(Collectors.toList());
        apartmentRegisterRepository.saveAll(apartmentRegisters);
        return modelConverter.mapAllByIterator(input, Output.class);
    }

    @Override
    protected void postExecute(List<Input> input) {

    }
}
