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
public class FloorFindByBuildingIdServiceImpl extends
    BaseService<FloorFindByBuildingId.Input, FloorFindByBuildingId.Output> implements
    FloorFindByBuildingId {

  private final FloorRepository floorRepository;
  private final ModelConverter modelConverter;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    Output output = new Output();
    output.setFloors(
        modelConverter.mapAllByIterator(floorRepository.findByBuildingId(input.getBuildingId()),
            Output.Floor.class));
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
