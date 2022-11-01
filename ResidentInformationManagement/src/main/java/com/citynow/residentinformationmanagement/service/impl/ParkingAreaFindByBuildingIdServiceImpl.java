package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ParkingAreaRepository;
import com.citynow.residentinformationmanagement.service.ParkingAreaFindByBuildingId;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingAreaFindByBuildingIdServiceImpl extends BaseService<ParkingAreaFindByBuildingId.Input, List<ParkingAreaFindByBuildingId.Output>> implements ParkingAreaFindByBuildingId {
    private final ParkingAreaRepository parkingAreaRepository;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected List<Output> doExecute(Input input) {
        return modelConverter.mapAllByIterator(parkingAreaRepository.findByBuildingId(input.getBuildingId()), Output.class);
    }

    @Override
    protected void postExecute(Input input) {

    }
}
