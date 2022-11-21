package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.BuildingRepository;
import com.citynow.residentinformationmanagement.service.BuildingFindByProjectId;
import com.citynow.residentinformationmanagement.service.BuildingFindByProjectId.Input;
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
public class BuildingFindByProjectIdServiceImplTest {

  @Mock
  private BuildingRepository buildingRepository;
  @Spy
  private ModelConverter modelConverter;
  @InjectMocks
  private BuildingFindByProjectIdServiceImpl buildingFindByProjectIdServiceImpl;

  @Test
  public void whenProjectIdIsNull_returnEmptyBuildingList() {
    Mockito.when(buildingRepository.findByProjectId(null)).thenReturn(new ArrayList<>());
    BuildingFindByProjectId.Input input = new Input();
    input.setProjectId(null);
    var actual = buildingFindByProjectIdServiceImpl.execute(input).getBuildings();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenProjectIdExisted_returnNonEmptyBuildingList() {
    String projectId = "5123c665";
    Mockito.when(buildingRepository.findByProjectId(projectId)).thenReturn(new ArrayList<>(3));
    BuildingFindByProjectId.Input input = new Input();
    input.setProjectId(projectId);
    var actual = buildingFindByProjectIdServiceImpl.execute(input).getBuildings();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>(3));
  }

  @Test
  public void whenProjectIdNotExisted_returnEmptyBuildingList() {
    String projectId = "das2342s";
    Mockito.when(buildingRepository.findByProjectId(projectId)).thenReturn(new ArrayList<>());
    BuildingFindByProjectId.Input input = new Input();
    input.setProjectId(projectId);
    var actual = buildingFindByProjectIdServiceImpl.execute(input).getBuildings();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }
}
