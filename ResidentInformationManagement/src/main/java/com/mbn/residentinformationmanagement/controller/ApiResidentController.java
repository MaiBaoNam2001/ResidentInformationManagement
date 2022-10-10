package com.mbn.residentinformationmanagement.controller;

import ch.qos.logback.core.joran.action.NOPAction;
import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.service.ResidentDeleteService;
import com.mbn.residentinformationmanagement.service.ResidentFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiResidentController {
    private final ResidentFetchService residentFetchService;
    private final ResidentDeleteService residentDeleteService;

    @GetMapping("/residents")
    public List<Resident> fetchResidents() {
        return residentFetchService.execute(null);
    }

    @DeleteMapping("/residents/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResident(@PathVariable(value = "id") String id) {
        residentDeleteService.execute(id);
    }
}
