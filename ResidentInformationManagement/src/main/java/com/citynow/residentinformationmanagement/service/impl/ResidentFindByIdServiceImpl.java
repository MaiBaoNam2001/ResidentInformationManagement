package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ResidentRepository;
import com.citynow.residentinformationmanagement.service.ResidentFindById;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResidentFindByIdServiceImpl extends BaseService<ResidentFindById.Input, ResidentFindById.Output> implements ResidentFindById {
    private final ResidentRepository residentRepository;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected Output doExecute(Input input) {
        return modelConverter.map(residentRepository.findById(input.getId()).get(), Output.class);
    }

    @Override
    protected void postExecute(Input input) {

    }
}
