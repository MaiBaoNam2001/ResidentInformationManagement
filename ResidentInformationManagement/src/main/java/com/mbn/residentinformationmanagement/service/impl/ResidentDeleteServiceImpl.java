package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.repository.ResidentRepository;
import com.mbn.residentinformationmanagement.service.ResidentDeleteService;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentDeleteServiceImpl extends BaseService<String, Boolean> implements ResidentDeleteService {
    private final ResidentRepository residentRepository;


    @Override
    protected void preExecute(String input) {

    }

    @Override
    protected Boolean doExecute(String input) {
        try {
            residentRepository.delete(residentRepository.getReferenceById(input));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void postExecute(String input) {

    }
}
