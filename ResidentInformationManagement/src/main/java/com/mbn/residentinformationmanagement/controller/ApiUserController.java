package com.mbn.residentinformationmanagement.controller;

import com.mbn.residentinformationmanagement.entity.User;
import com.mbn.residentinformationmanagement.service.UserFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiUserController {
    private final UserFetchService userFetchService;

    @GetMapping("/users")
    public List<User> fetchUsers() {
        return userFetchService.execute(null);
    }
}
