package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.entity.Resident;
import com.citynow.residentinformationmanagement.repository.ResidentRepository;
import com.citynow.residentinformationmanagement.service.ResidentUpdate;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResidentUpdateServiceImpl extends BaseService<ResidentUpdate.Input, ResidentUpdate.Output> implements ResidentUpdate {
    private final ResidentRepository residentRepository;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected Output doExecute(Input input) {
        Resident resident = modelConverter.map(input, Resident.class);
        return modelConverter.map(residentRepository.save(resident), Output.class);
    }

    @Override
    protected void postExecute(Input input) {

    }
}