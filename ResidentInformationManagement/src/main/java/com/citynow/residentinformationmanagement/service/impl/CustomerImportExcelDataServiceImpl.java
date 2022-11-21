package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.common.util.ExcelUtils;
import com.citynow.residentinformationmanagement.service.CustomerImportExcelData;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import java.util.ArrayList;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerImportExcelDataServiceImpl extends
    BaseService<CustomerImportExcelData.Input, CustomerImportExcelData.Output> implements
    CustomerImportExcelData {

  private final ModelConverter modelConverter;

  @Override
  protected void preExecute(Input input) {

  }

  @Override
  protected Output doExecute(Input input) {
    XSSFWorkbook workbook = ExcelUtils.initWorkbook(input.getMultipartFile());
    Output output = new Output();
    output.setCustomers(modelConverter.mapAllByIterator(ExcelUtils.readCustomerExcelData(workbook),
        Output.Customer.class));
    return output;
  }

  @Override
  protected void postExecute(Input input) {

  }
}
