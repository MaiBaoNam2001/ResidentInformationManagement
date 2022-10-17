package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.entity.Resident;
import com.citynow.residentinformationmanagement.repository.ResidentRepository;
import com.citynow.residentinformationmanagement.service.ResidentDelete;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResidentDeleteServiceImpl extends BaseService<ResidentDelete.Input, ResidentDelete.Output> implements ResidentDelete {
    private final ResidentRepository residentRepository;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected Output doExecute(Input input) {
        Resident resident = residentRepository.findById(input.getId()).get();
        residentRepository.delete(resident);
        return modelConverter.map(resident, Output.class);
    }

    @Override
    protected void postExecute(Input input) {

    }
}
