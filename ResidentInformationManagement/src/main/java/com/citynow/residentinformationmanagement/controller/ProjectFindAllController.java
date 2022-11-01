package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.ProjectFindAllResponse;
import com.citynow.residentinformationmanagement.service.ProjectFindAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectFindAllController {
    private final ProjectFindAll projectFindAll;
    private final ModelConverter modelConverter;

    @GetMapping("/projects")
    public List<ProjectFindAllResponse> findAllProjects() {
        return modelConverter.mapAllByIterator(projectFindAll.execute(new ProjectFindAll.Input()), ProjectFindAllResponse.class);
    }
}
