package com.mbn.residentinformationmanagement.controller;

import com.mbn.residentinformationmanagement.entity.Role;
import com.mbn.residentinformationmanagement.service.RoleFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiRoleController {
    private final RoleFetchService roleFetchService;

    @GetMapping("/roles")
    public List<Role> fetchRoles() {
        return roleFetchService.execute(null);
    }
}
