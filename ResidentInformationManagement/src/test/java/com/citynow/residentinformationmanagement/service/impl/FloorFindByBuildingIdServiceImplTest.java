package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.FloorRepository;
import com.citynow.residentinformationmanagement.service.FloorFindByBuildingId;
import com.citynow.residentinformationmanagement.service.FloorFindByBuildingId.Input;
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
public class FloorFindByBuildingIdServiceImplTest {

  @Mock
  private FloorRepository floorRepository;
  @Spy
  private ModelConverter modelConverter;

  @InjectMocks
  private FloorFindByBuildingIdServiceImpl floorFindByBuildingIdServiceImpl;

  @Test
  public void whenBuildingIdIsNull_returnEmptyFloorList() {
    Mockito.when(floorRepository.findByBuildingId(null)).thenReturn(new ArrayList<>());
    FloorFindByBuildingId.Input input = new Input();
    input.setBuildingId(null);
    var actual = floorFindByBuildingIdServiceImpl.execute(input).getFloors();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenBuildingIdExisted_returnNonEmptyFloorList() {
    String buildingId = "714b9776";
    Mockito.when(floorRepository.findByBuildingId(buildingId)).thenReturn(new ArrayList<>(3));
    FloorFindByBuildingId.Input input = new Input();
    input.setBuildingId(buildingId);
    var actual = floorFindByBuildingIdServiceImpl.execute(input).getFloors();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>(3));
  }

  @Test
  public void whenBuildingIdNotExisted_returnEmptyFloorList() {
    String buildingId = "as54khj3";
    Mockito.when(floorRepository.findByBuildingId(buildingId)).thenReturn(new ArrayList<>());
    FloorFindByBuildingId.Input input = new Input();
    input.setBuildingId(buildingId);
    var actual = floorFindByBuildingIdServiceImpl.execute(input).getFloors();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }
}
