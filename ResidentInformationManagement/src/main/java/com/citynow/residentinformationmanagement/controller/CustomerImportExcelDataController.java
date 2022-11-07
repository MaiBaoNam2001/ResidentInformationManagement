package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.CustomerImportExcelDataResponse;
import com.citynow.residentinformationmanagement.service.CustomerImportExcelData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerImportExcelDataController {
    private final CustomerImportExcelData customerImportExcelData;
    private final ModelConverter modelConverter;

    @PostMapping("/customers/import-excel")
    public List<CustomerImportExcelDataResponse> importCustomerDataFromExcel(@RequestParam(value = "file") MultipartFile multipartFile) {
        CustomerImportExcelData.Input input = new CustomerImportExcelData.Input();
        input.setMultipartFile(multipartFile);
        return modelConverter.mapAllByIterator(customerImportExcelData.execute(input), CustomerImportExcelDataResponse.class);
    }
}
