package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.BuildingRepository;
import com.citynow.residentinformationmanagement.service.BuildingFindByProjectId;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingFindByProjectIdServiceImpl extends
    BaseService<BuildingFindByProjectId.Input, BuildingFindByProjectId.Output> implements
    BuildingFindByProjectId {

  private final BuildingRepository buildingRepository;
  private final ModelConverter modelConverter;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    Output output = new Output();
    output.setBuildings(
        modelConverter.mapAllByIterator(buildingRepository.findByProjectId(input.getProjectId()),
            Output.Building.class));
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
