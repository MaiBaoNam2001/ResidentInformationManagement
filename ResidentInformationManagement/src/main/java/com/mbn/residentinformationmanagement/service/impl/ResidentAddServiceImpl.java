package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.repository.ResidentRepository;
import com.mbn.residentinformationmanagement.service.ResidentAddService;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentAddServiceImpl extends BaseService<Resident, Resident> implements ResidentAddService {
    private final ResidentRepository residentRepository;

    @Override
    protected void preExecute(Resident input) {

    }

    @Override
    protected Resident doExecute(Resident input) {
        return residentRepository.save(input);
    }

    @Override
    protected void postExecute(Resident input) {

    }
}
