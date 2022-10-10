package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.repository.ResidentRepository;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import com.mbn.residentinformationmanagement.service.ResidentFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentFetchServiceImpl extends BaseService<String, List<Resident>> implements ResidentFetchService {
    private final ResidentRepository residentRepository;

    @Override
    protected void preExecute(String input) {

    }

    @Override
    protected List<Resident> doExecute(String input) {
        return residentRepository.findAll();
    }

    @Override
    protected void postExecute(String input) {

    }
}
