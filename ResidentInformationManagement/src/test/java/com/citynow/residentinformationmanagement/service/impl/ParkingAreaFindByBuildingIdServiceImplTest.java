package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ParkingAreaRepository;
import com.citynow.residentinformationmanagement.service.ParkingAreaFindByBuildingId;
import com.citynow.residentinformationmanagement.service.ParkingAreaFindByBuildingId.Input;
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
public class ParkingAreaFindByBuildingIdServiceImplTest {

  @Mock
  private ParkingAreaRepository parkingAreaRepository;
  @Spy
  private ModelConverter modelConverter;
  @InjectMocks
  private ParkingAreaFindByBuildingIdServiceImpl parkingAreaFindByBuildingIdServiceImpl;

  @Test
  public void whenBuildingIdIsNull_returnEmptyParkingAreaList() {
    Mockito.when(parkingAreaRepository.findByBuildingId(null)).thenReturn(new ArrayList<>());
    ParkingAreaFindByBuildingId.Input input = new Input();
    input.setBuildingId(null);
    var actual = parkingAreaFindByBuildingIdServiceImpl.execute(input).getParkingAreas();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenBuildingIdExisted_returnNonEmptyParkingAreaList() {
    String buildingId = "714b9776";
    Mockito.when(parkingAreaRepository.findByBuildingId(buildingId)).thenReturn(new ArrayList<>(1));
    ParkingAreaFindByBuildingId.Input input = new Input();
    input.setBuildingId(buildingId);
    var actual = parkingAreaFindByBuildingIdServiceImpl.execute(input).getParkingAreas();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>(1));
  }

  @Test
  public void whenBuildingIdNotExisted_returnEmptyParkingAreaList() {
    String buildingId = "af1d43ad";
    Mockito.when(parkingAreaRepository.findByBuildingId(buildingId)).thenReturn(new ArrayList<>());
    ParkingAreaFindByBuildingId.Input input = new Input();
    input.setBuildingId(buildingId);
    var actual = parkingAreaFindByBuildingIdServiceImpl.execute(input).getParkingAreas();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }
}
