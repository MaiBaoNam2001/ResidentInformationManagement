package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.BuildingFindByProjectIdResponse;
import com.citynow.residentinformationmanagement.service.BuildingFindByProjectId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BuildingFindByProjectIdController {
    private final BuildingFindByProjectId buildingFindByProjectId;
    private final ModelConverter modelConverter;

    @GetMapping("/buildings/{projectId}")
    public List<BuildingFindByProjectIdResponse> findBuildingsByProjectId(@PathVariable(value = "projectId") String projectId) {
        BuildingFindByProjectId.Input input = new BuildingFindByProjectId.Input();
        input.setProjectId(projectId);
        return modelConverter.mapAllByIterator(buildingFindByProjectId.execute(input), BuildingFindByProjectIdResponse.class);
    }
}
