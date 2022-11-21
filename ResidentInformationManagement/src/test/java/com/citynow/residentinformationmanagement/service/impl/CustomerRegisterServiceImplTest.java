package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.entity.Apartment;
import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.Customer;
import com.citynow.residentinformationmanagement.mapper.ApartmentRegisterMapper;
import com.citynow.residentinformationmanagement.repository.ApartmentRegisterRepository;
import com.citynow.residentinformationmanagement.repository.ApartmentRepository;
import com.citynow.residentinformationmanagement.repository.CustomerRepository;
import com.citynow.residentinformationmanagement.service.CustomerRegister;
import com.citynow.residentinformationmanagement.service.CustomerRegister.Input;
import com.citynow.residentinformationmanagement.service.CustomerRegister.Output;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerRegisterServiceImplTest {

  @Mock
  private ApartmentRegisterRepository apartmentRegisterRepository;
  @Mock
  private ApartmentRegisterMapper apartmentRegisterMapper;
  @InjectMocks
  private CustomerRegisterServiceImpl customerRegisterServiceImpl;

  @Test
  public void whenCustomerListIsNull_returnEmptyCustomerList() {
    Mockito.when(apartmentRegisterRepository.saveAll(new ArrayList<>()))
        .thenReturn(new ArrayList<>());
    CustomerRegister.Input input = new Input();
    input.setCustomers(null);
    var actual = customerRegisterServiceImpl.execute(input).getCustomers();
    Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
  }

  @Test
  public void whenCustomerListIsNotNullAndExistCustomersWithApartmentRegisterIdIsEmpty_returnNonEmptyCustomerListWithThisCustomersHaveBeenGeneratedApartmentRegisterId() {
    Input.Customer inputCustomer = new Input.Customer();
    inputCustomer.setId("879b6f7e");
    inputCustomer.setName("Đào Duy Anh");
    inputCustomer.setDateOfBirth(LocalDate.of(1999, 10, 25));
    inputCustomer.setGender("Nam");
    inputCustomer.setPhone("0280318371");
    inputCustomer.setEmail("duyanh.dao@gmail.com");
    inputCustomer.setAddress("Đồng Tháp");
    inputCustomer.setType("Cư dân");
    inputCustomer.setIdentityCard("318361865");
    inputCustomer.setRegisterDate(LocalDate.now());
    inputCustomer.setProjectId("6d1c2ca7");
    inputCustomer.setBuildingId("d10819dd");
    inputCustomer.setFloorId("54e50255");
    inputCustomer.setApartmentId("1118eae6");
    inputCustomer.setParkingAreaId("7cd3214e");
    inputCustomer.setHost(false);
    inputCustomer.setResidentCard(true);
    inputCustomer.setMotorbikeCard(true);
    inputCustomer.setCarCard(false);
    inputCustomer.setApartmentRegisterId("");
    inputCustomer.setDeleted(false);
    List<Input.Customer> inputCustomers = new ArrayList<>();
    inputCustomers.add(inputCustomer);

    Customer customer = new Customer();
    customer.setId(inputCustomer.getId());
    Apartment apartment = new Apartment();
    apartment.setId(inputCustomer.getApartmentId());
    ApartmentRegister apartmentRegister = new ApartmentRegister();
    apartmentRegister.setId("c267ec18");
    apartmentRegister.setCustomer(customer);
    apartmentRegister.setApartment(apartment);
    List<ApartmentRegister> apartmentRegisters = new ArrayList<>();
    apartmentRegisters.add(apartmentRegister);

    Output.Customer outputCustomer = new Output.Customer();
    outputCustomer.setId("879b6f7e");
    outputCustomer.setName("Đào Duy Anh");
    outputCustomer.setDateOfBirth(LocalDate.of(1999, 10, 25));
    outputCustomer.setGender("Nam");
    outputCustomer.setPhone("0280318371");
    outputCustomer.setEmail("duyanh.dao@gmail.com");
    outputCustomer.setAddress("Đồng Tháp");
    outputCustomer.setType("Cư dân");
    outputCustomer.setIdentityCard("318361865");
    outputCustomer.setRegisterDate(LocalDate.now());
    outputCustomer.setProjectId("6d1c2ca7");
    outputCustomer.setBuildingId("d10819dd");
    outputCustomer.setFloorId("54e50255");
    outputCustomer.setApartmentId("1118eae6");
    outputCustomer.setParkingAreaId("7cd3214e");
    outputCustomer.setHost(false);
    outputCustomer.setResidentCard(true);
    outputCustomer.setMotorbikeCard(true);
    outputCustomer.setCarCard(false);
    outputCustomer.setApartmentRegisterId(apartmentRegister.getId());
    outputCustomer.setDeleted(false);
    List<Output.Customer> outputCustomers = new ArrayList<>();
    outputCustomers.add(outputCustomer);

    Mockito.when(apartmentRegisterMapper.toApartmentRegister(inputCustomers.get(0)))
        .thenReturn(apartmentRegisters.get(0));
    Mockito.when(apartmentRegisterRepository.saveAll(apartmentRegisters))
        .thenReturn(apartmentRegisters);
    Mockito.when(apartmentRegisterMapper.toCustomerRegisterOutput(apartmentRegisters.get(0)))
        .thenReturn(outputCustomers.get(0));
    CustomerRegister.Input input = new Input();
    input.setCustomers(inputCustomers);
    var actual = customerRegisterServiceImpl.execute(input).getCustomers().get(0)
        .getApartmentRegisterId();
    Assertions.assertThat(actual).isNotEqualTo("");
  }

  @Test
  public void whenCustomerListIsNotNullAndExistCustomersWithApartmentRegisterIdIsNotEmpty_returnNonEmptyCustomerListWithThisCustomersHaveNotBeenGeneratedApartmentRegisterId() {
    Input.Customer inputCustomer = new Input.Customer();
    inputCustomer.setId("879b6f7e");
    inputCustomer.setName("Đào Duy Anh");
    inputCustomer.setDateOfBirth(LocalDate.of(1999, 10, 25));
    inputCustomer.setGender("Nam");
    inputCustomer.setPhone("0280318371");
    inputCustomer.setEmail("duyanh.dao@gmail.com");
    inputCustomer.setAddress("Đồng Tháp");
    inputCustomer.setType("Cư dân");
    inputCustomer.setIdentityCard("318361865");
    inputCustomer.setRegisterDate(LocalDate.now());
    inputCustomer.setProjectId("6d1c2ca7");
    inputCustomer.setBuildingId("d10819dd");
    inputCustomer.setFloorId("54e50255");
    inputCustomer.setApartmentId("1118eae6");
    inputCustomer.setParkingAreaId("7cd3214e");
    inputCustomer.setHost(false);
    inputCustomer.setResidentCard(true);
    inputCustomer.setMotorbikeCard(true);
    inputCustomer.setCarCard(false);
    inputCustomer.setApartmentRegisterId("c267ec18");
    inputCustomer.setDeleted(false);
    List<Input.Customer> inputCustomers = new ArrayList<>();
    inputCustomers.add(inputCustomer);

    Customer customer = new Customer();
    customer.setId(inputCustomer.getId());
    Apartment apartment = new Apartment();
    apartment.setId(inputCustomer.getApartmentId());
    ApartmentRegister apartmentRegister = new ApartmentRegister();
    apartmentRegister.setId("c267ec18");
    apartmentRegister.setCustomer(customer);
    apartmentRegister.setApartment(apartment);
    List<ApartmentRegister> apartmentRegisters = new ArrayList<>();
    apartmentRegisters.add(apartmentRegister);

    Output.Customer outputCustomer = new Output.Customer();
    outputCustomer.setId("879b6f7e");
    outputCustomer.setName("Đào Duy Anh");
    outputCustomer.setDateOfBirth(LocalDate.of(1999, 10, 25));
    outputCustomer.setGender("Nam");
    outputCustomer.setPhone("0280318371");
    outputCustomer.setEmail("duyanh.dao@gmail.com");
    outputCustomer.setAddress("Đồng Tháp");
    outputCustomer.setType("Cư dân");
    outputCustomer.setIdentityCard("318361865");
    outputCustomer.setRegisterDate(LocalDate.now());
    outputCustomer.setProjectId("6d1c2ca7");
    outputCustomer.setBuildingId("d10819dd");
    outputCustomer.setFloorId("54e50255");
    outputCustomer.setApartmentId("1118eae6");
    outputCustomer.setParkingAreaId("7cd3214e");
    outputCustomer.setHost(false);
    outputCustomer.setResidentCard(true);
    outputCustomer.setMotorbikeCard(true);
    outputCustomer.setCarCard(false);
    outputCustomer.setApartmentRegisterId(apartmentRegister.getId());
    outputCustomer.setDeleted(false);
    List<Output.Customer> outputCustomers = new ArrayList<>();
    outputCustomers.add(outputCustomer);

    Mockito.when(apartmentRegisterMapper.toApartmentRegister(inputCustomers.get(0)))
        .thenReturn(apartmentRegisters.get(0));
    Mockito.when(apartmentRegisterRepository.saveAll(apartmentRegisters))
        .thenReturn(apartmentRegisters);
    Mockito.when(apartmentRegisterMapper.toCustomerRegisterOutput(apartmentRegisters.get(0)))
        .thenReturn(outputCustomers.get(0));
    CustomerRegister.Input input = new Input();
    input.setCustomers(inputCustomers);
    var actual = customerRegisterServiceImpl.execute(input).getCustomers().get(0)
        .getApartmentRegisterId();
    Assertions.assertThat(actual).isEqualTo("c267ec18");
  }
}
