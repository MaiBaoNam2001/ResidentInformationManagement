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

@Component
public class ExcelUtils {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void initWorkbook(InputStream inputStream) {
        try {
            this.workbook = new XSSFWorkbook(inputStream);
            this.sheet = this.workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> readCustomerExcelData() {
        List<Customer> customers = new ArrayList<>();
        for (int index = 1; index < this.sheet.getPhysicalNumberOfRows(); index++) {
            XSSFRow row = this.sheet.getRow(index);
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
