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
public class ParkingAreaFindByBuildingIdServiceImpl extends
    BaseService<ParkingAreaFindByBuildingId.Input, ParkingAreaFindByBuildingId.Output> implements
    ParkingAreaFindByBuildingId {

  private final ParkingAreaRepository parkingAreaRepository;
  private final ModelConverter modelConverter;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    Output output = new Output();
    output.setParkingAreas(modelConverter.mapAllByIterator(
        parkingAreaRepository.findByBuildingId(input.getBuildingId()), Output.ParkingArea.class));
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
