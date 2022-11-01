package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.FloorFindByBuildingIdResponse;
import com.citynow.residentinformationmanagement.service.FloorFindByBuildingId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FloorFindByBuildingIdController {
    private final FloorFindByBuildingId floorFindByBuildingId;
    private final ModelConverter modelConverter;

    @GetMapping("/floors/{buildingId}")
    public List<FloorFindByBuildingIdResponse> findFloorsByBuildingId(@PathVariable(value = "buildingId") String buildingId) {
        FloorFindByBuildingId.Input input = new FloorFindByBuildingId.Input();
        input.setBuildingId(buildingId);
        return modelConverter.mapAllByIterator(floorFindByBuildingId.execute(input), FloorFindByBuildingIdResponse.class);
    }
}
