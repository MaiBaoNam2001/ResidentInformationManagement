package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.User;
import com.mbn.residentinformationmanagement.repository.UserRepository;
import com.mbn.residentinformationmanagement.service.UserFetchService;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserFetchServiceImpl extends BaseService<String, List<User>> implements UserFetchService {
    private final UserRepository userRepository;

    @Override
    protected void preExecute(String input) {

    }

    @Override
    protected List<User> doExecute(String input) {
        return userRepository.findAll();
    }

    @Override
    protected void postExecute(String input) {

    }
}
