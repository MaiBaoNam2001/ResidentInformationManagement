package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ProjectRepository;
import com.citynow.residentinformationmanagement.service.ProjectFindAll;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectFindAllServiceImpl extends
    BaseService<ProjectFindAll.Input, ProjectFindAll.Output> implements ProjectFindAll {

  private final ProjectRepository projectRepository;
  private final ModelConverter modelConverter;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    Output output = new Output();
    output.setProjects(
        modelConverter.mapAllByIterator(projectRepository.findAll(), Output.Project.class));
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
