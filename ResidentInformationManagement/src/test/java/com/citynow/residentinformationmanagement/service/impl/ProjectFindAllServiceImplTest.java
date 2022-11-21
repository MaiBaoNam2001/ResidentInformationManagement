package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ProjectRepository;
import com.citynow.residentinformationmanagement.service.ProjectFindAll;
import com.citynow.residentinformationmanagement.service.ProjectFindAll.Input;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProjectFindAllServiceImplTest {

  @Mock
  private ProjectRepository projectRepository;
  @Spy
  private ModelConverter modelConverter;
  @InjectMocks
  private ProjectFindAllServiceImpl projectFindAllServiceImpl;

  @Test
  public void whenFindAllProjects_returnNonEmptyProjectList() {
    Mockito.when(projectRepository.findAll()).thenReturn(new ArrayList<>(5));
    ProjectFindAll.Input input = new Input();
    var actual = projectFindAllServiceImpl.execute(input).getProjects();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>(5));
  }
}