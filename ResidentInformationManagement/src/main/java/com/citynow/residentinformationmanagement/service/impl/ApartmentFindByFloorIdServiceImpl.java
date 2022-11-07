package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ApartmentRepository;
import com.citynow.residentinformationmanagement.service.ApartmentFindByFloorId;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentFindByFloorIdServiceImpl extends BaseService<ApartmentFindByFloorId.Input, List<ApartmentFindByFloorId.Output>> implements ApartmentFindByFloorId {
    private final ApartmentRepository apartmentRepository;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected List<Output> doExecute(Input input) {
        return modelConverter.mapAllByIterator(apartmentRepository.findByFloorId(input.getFloorId()), Output.class);
    }

    @Override
    protected void postExecute(Input input) {

    }
}
