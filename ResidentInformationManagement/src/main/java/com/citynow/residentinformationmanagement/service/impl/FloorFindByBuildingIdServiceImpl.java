package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.FloorRepository;
import com.citynow.residentinformationmanagement.service.FloorFindByBuildingId;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FloorFindByBuildingIdServiceImpl extends BaseService<FloorFindByBuildingId.Input, List<FloorFindByBuildingId.Output>> implements FloorFindByBuildingId {
    private final FloorRepository floorRepository;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected List<Output> doExecute(Input input) {
        return modelConverter.mapAllByIterator(floorRepository.findByBuildingId(input.getBuildingId()), Output.class);
    }

    @Override
    protected void postExecute(Input input) {

    }
}
