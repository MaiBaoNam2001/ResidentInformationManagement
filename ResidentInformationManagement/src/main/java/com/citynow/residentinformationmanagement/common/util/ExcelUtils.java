package com.citynow.residentinformationmanagement.common.util;

import com.citynow.residentinformationmanagement.entity.Customer;
import com.citynow.residentinformationmanagement.entity.CustomerExcelData;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ExcelUtils {

  private static XSSFWorkbook workbook;
  private static XSSFSheet sheet;

  public static XSSFWorkbook initWorkbook(MultipartFile multipartFile) {
    try {
      return new XSSFWorkbook(multipartFile.getInputStream());
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static List<Customer> readCustomerExcelData(XSSFWorkbook workbook) {
    sheet = workbook.getSheetAt(0);
    List<Customer> customers = new ArrayList<>();
    for (int index = 1; index < sheet.getPhysicalNumberOfRows(); index++) {
      XSSFRow row = sheet.getRow(index);
      Customer customer = new Customer();
      customer.setId(row.getCell(0).getStringCellValue());
      customer.setName(row.getCell(1).getStringCellValue());
      customer.setDateOfBirth(row.getCell(2).getLocalDateTimeCellValue().toLocalDate());
      customer.setGender(row.getCell(3).getStringCellValue());
      customer.setPhone(row.getCell(4).getStringCellValue());
      customer.setEmail(row.getCell(5).getStringCellValue());
      customer.setAddress(row.getCell(6).getStringCellValue());
      customer.setType(null);
      customer.setIdentityCard(row.getCell(7).getStringCellValue());
      customers.add(customer);
    }
    return customers;
  }
}
