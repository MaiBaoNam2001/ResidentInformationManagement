package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.Role;
import com.mbn.residentinformationmanagement.repository.RoleRepository;
import com.mbn.residentinformationmanagement.service.RoleFetchService;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleFetchServiceImpl extends BaseService<String, List<Role>> implements RoleFetchService {
    private final RoleRepository roleRepository;

    @Override
    protected void preExecute(String input) {

    }

    @Override
    protected List<Role> doExecute(String input) {
        return roleRepository.findAll();
    }

    @Override
    protected void postExecute(String input) {

    }
}
