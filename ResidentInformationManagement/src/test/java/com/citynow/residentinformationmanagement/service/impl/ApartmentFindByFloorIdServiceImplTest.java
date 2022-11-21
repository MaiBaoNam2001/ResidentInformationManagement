package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.repository.ApartmentRepository;
import com.citynow.residentinformationmanagement.service.ApartmentFindByFloorId;
import com.citynow.residentinformationmanagement.service.ApartmentFindByFloorId.Input;
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
public class ApartmentFindByFloorIdServiceImplTest {

  @Mock
  private ApartmentRepository apartmentRepository;
  @Spy
  private ModelConverter modelConverter;
  @InjectMocks
  private ApartmentFindByFloorIdServiceImpl apartmentFindByFloorIdServiceImpl;

  @Test
  public void whenFloorIdIsNull_returnEmptyApartmentList() {
    Mockito.when(apartmentRepository.findByFloorId(null)).thenReturn(new ArrayList<>());
    ApartmentFindByFloorId.Input input = new Input();
    input.setFloorId(null);
    var actual = apartmentFindByFloorIdServiceImpl.execute(input).getApartments();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenFloorIdExisted_returnNonEmptyApartmentList() {
    String floorId = "7cf9cd22";
    Mockito.when(apartmentRepository.findByFloorId(floorId)).thenReturn(new ArrayList<>(3));
    ApartmentFindByFloorId.Input input = new Input();
    input.setFloorId(floorId);
    var actual = apartmentFindByFloorIdServiceImpl.execute(input).getApartments();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>(3));
  }

  @Test
  public void whenFloorIdNotExisted_returnEmptyApartmentList() {
    String floorId = "abcd1234";
    Mockito.when(apartmentRepository.findByFloorId(floorId)).thenReturn(new ArrayList<>());
    ApartmentFindByFloorId.Input input = new Input();
    input.setFloorId(floorId);
    var actual = apartmentFindByFloorIdServiceImpl.execute(input).getApartments();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }
}
