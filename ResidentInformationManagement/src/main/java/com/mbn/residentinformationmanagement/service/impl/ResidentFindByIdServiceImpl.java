package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.repository.ResidentRepository;
import com.mbn.residentinformationmanagement.service.ResidentFindByIdService;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentFindByIdServiceImpl extends BaseService<String, Optional<Resident>> implements ResidentFindByIdService {
    private final ResidentRepository residentRepository;

    @Override
    protected void preExecute(String input) {

    }

    @Override
    protected Optional<Resident> doExecute(String input) {
        return residentRepository.findById(input);
    }

    @Override
    protected void postExecute(String input) {

    }
}
