package com.citynow.residentinformationmanagement.service.impl;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.common.util.ExcelUtils;
import com.citynow.residentinformationmanagement.service.CustomerImportExcelData;
import com.citynow.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerImportExcelDataServiceImpl extends BaseService<CustomerImportExcelData.Input, List<CustomerImportExcelData.Output>> implements CustomerImportExcelData {
    private final ExcelUtils excelUtils;
    private final ModelConverter modelConverter;

    @Override
    protected void preExecute(Input input) {

    }

    @Override
    protected List<Output> doExecute(Input input) {
        try {
            excelUtils.initWorkbook(input.getMultipartFile().getInputStream());
            return modelConverter.mapAllByIterator(excelUtils.readCustomerExcelData(), Output.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void postExecute(Input input) {

    }
}
