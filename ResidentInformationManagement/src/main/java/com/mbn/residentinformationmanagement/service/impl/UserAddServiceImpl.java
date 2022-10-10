package com.mbn.residentinformationmanagement.service.impl;

import com.mbn.residentinformationmanagement.entity.User;
import com.mbn.residentinformationmanagement.repository.UserRepository;
import com.mbn.residentinformationmanagement.service.UserAddService;
import com.mbn.residentinformationmanagement.service.template.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAddServiceImpl extends BaseService<User, User> implements UserAddService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void preExecute(User input) {

    }

    @Override
    protected User doExecute(User input) {
        input.setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(input);
    }

    @Override
    protected void postExecute(User input) {

    }
}
