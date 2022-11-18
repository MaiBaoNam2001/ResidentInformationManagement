package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.mapper.ApartmentRegisterMapper;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.service.ApartmentRegisterFindByApartmentId;
import com.citynow.residentinformationmanagement.service.ApartmentRegisterFindByApartmentId.Input;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApartmentRegisterFindByApartmentIdServiceImplTest {

  @Mock
  private ApartmentRegisterRepository apartmentRegisterRepository;
  @Mock
  private ApartmentRegisterMapper apartmentRegisterMapper;
  @InjectMocks
  private ApartmentRegisterFindByApartmentIdServiceImpl apartmentRegisterFindByApartmentIdServiceImpl;

  @Test
  public void whenApartmentIdIsNull_returnEmptyApartmentRegisterList() {
    Mockito.when(apartmentRegisterRepository.findByApartmentId(null)).thenReturn(new ArrayList<>());
    ApartmentRegisterFindByApartmentId.Input input = new Input();
    input.setApartmentId(null);
    var actual = apartmentRegisterFindByApartmentIdServiceImpl.execute(input)
        .getApartmentRegisters();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenApartmentIdExistedAndInsideApartmentRegisterTable_returnNonEmptyApartmentRegisterList() {
    String apartmentId = "1118eae6";
    Mockito.when(apartmentRegisterRepository.findByApartmentId(apartmentId))
        .thenReturn(new ArrayList<>(10));
    ApartmentRegisterFindByApartmentId.Input input = new Input();
    input.setApartmentId(apartmentId);
    var actual = apartmentRegisterFindByApartmentIdServiceImpl.execute(input)
        .getApartmentRegisters();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>(10));
  }

  @Test
  public void whenApartmentIdExistedAndNotInsideApartmentRegisterTable_returnEmptyApartmentRegisterList() {
    String apartmentId = "0c775c87";
    Mockito.when(apartmentRegisterRepository.findByApartmentId(apartmentId))
        .thenReturn(new ArrayList<>());
    ApartmentRegisterFindByApartmentId.Input input = new Input();
    input.setApartmentId(apartmentId);
    var actual = apartmentRegisterFindByApartmentIdServiceImpl.execute(input)
        .getApartmentRegisters();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenApartmentIdNotExisted_returnEmptyApartmentRegisterList() {
    String apartmentId = "adkjg342";
    Mockito.when(apartmentRegisterRepository.findByApartmentId(apartmentId))
        .thenReturn(new ArrayList<>());
    ApartmentRegisterFindByApartmentId.Input input = new Input();
    input.setApartmentId(apartmentId);
    var actual = apartmentRegisterFindByApartmentIdServiceImpl.execute(input)
        .getApartmentRegisters();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }
}
