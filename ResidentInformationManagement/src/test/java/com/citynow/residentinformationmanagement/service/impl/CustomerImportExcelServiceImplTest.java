package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.common.util.ExcelUtils;
import com.citynow.residentinformationmanagement.service.CustomerImportExcelData;
import com.citynow.residentinformationmanagement.service.CustomerImportExcelData.Input;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@ExtendWith(MockitoExtension.class)
public class CustomerImportExcelServiceImplTest {

  @Spy
  private ModelConverter modelConverter;
  @InjectMocks
  private CustomerImportExcelDataServiceImpl customerImportExcelDataServiceImpl;

  @Test
  public void whenMultipartFileIsNull_returnEmptyCustomerList() {
    try (MockedStatic<ExcelUtils> excelUtilsMockedStatic = Mockito.mockStatic(ExcelUtils.class)) {
      excelUtilsMockedStatic.when(() -> ExcelUtils.initWorkbook(null)).thenReturn(null);
      excelUtilsMockedStatic.when(() -> ExcelUtils.readCustomerExcelData(null))
          .thenReturn(new ArrayList<>());
      CustomerImportExcelData.Input input = new Input();
      input.setMultipartFile(null);
      var actual = customerImportExcelDataServiceImpl.execute(input).getCustomers();
      Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
    }
  }

  @Test
  public void whenMultipartFileIsExcelFileAndCorrectFormat_returnNonEmptyCustomerList()
      throws IOException {
    File file = new File("src/main/resources/excel/resident_1.xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
    try (MockedStatic<ExcelUtils> excelUtilsMockedStatic = Mockito.mockStatic(ExcelUtils.class)) {
      excelUtilsMockedStatic.when(() -> ExcelUtils.initWorkbook(multipartFile))
          .thenReturn(new XSSFWorkbook(multipartFile.getInputStream()));
      excelUtilsMockedStatic.when(
              () -> ExcelUtils.readCustomerExcelData(new XSSFWorkbook(multipartFile.getInputStream())))
          .thenReturn(new ArrayList<>(3));
      CustomerImportExcelData.Input input = new Input();
      input.setMultipartFile(multipartFile);
      var actual = customerImportExcelDataServiceImpl.execute(input).getCustomers();
      Assertions.assertThat(actual).isEqualTo(new ArrayList<>(3));
    }
  }

  @Test
  public void whenMultipartFileIsExcelFileAndIncorrectFormat_returnEmptyCustomerList()
      throws IOException {
    File file = new File("src/main/resources/excel/resident_error.xlsx");
    FileInputStream fileInputStream = new FileInputStream(file);
    MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
    try (MockedStatic<ExcelUtils> excelUtilsMockedStatic = Mockito.mockStatic(ExcelUtils.class)) {
      excelUtilsMockedStatic.when(() -> ExcelUtils.initWorkbook(multipartFile)).thenReturn(null);
      excelUtilsMockedStatic.when(() -> ExcelUtils.readCustomerExcelData(null))
          .thenReturn(new ArrayList<>());
      CustomerImportExcelData.Input input = new Input();
      input.setMultipartFile(multipartFile);
      var actual = customerImportExcelDataServiceImpl.execute(input).getCustomers();
      Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
    }
  }

  @Test
  public void whenMultipartFileIsNotExcelFile_returnEmptyCustomerList() throws IOException {
    File file = new File("src/main/resources/word/word.docx");
    FileInputStream fileInputStream = new FileInputStream(file);
    MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
    try (MockedStatic<ExcelUtils> excelUtilsMockedStatic = Mockito.mockStatic(ExcelUtils.class)) {
      excelUtilsMockedStatic.when(() -> ExcelUtils.initWorkbook(multipartFile)).thenReturn(null);
      excelUtilsMockedStatic.when(() -> ExcelUtils.readCustomerExcelData(null))
          .thenReturn(new ArrayList<>());
      CustomerImportExcelData.Input input = new Input();
      input.setMultipartFile(multipartFile);
      var actual = customerImportExcelDataServiceImpl.execute(input).getCustomers();
      Assertions.assertThat(actual).isEqualTo(new ArrayList<>());
    }
  }
}
