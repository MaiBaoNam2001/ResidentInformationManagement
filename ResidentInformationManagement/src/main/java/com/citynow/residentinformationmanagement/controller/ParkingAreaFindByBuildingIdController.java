package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.ParkingAreaFindByBuildingIdResponse;
import com.citynow.residentinformationmanagement.service.ParkingAreaFindByBuildingId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ParkingAreaFindByBuildingIdController {
    private final ParkingAreaFindByBuildingId parkingAreaFindByBuildingId;
    private final ModelConverter modelConverter;

    @GetMapping("/parking-areas/{buildingId}")
    public List<ParkingAreaFindByBuildingIdResponse> findParkingAreasByBuildingId(@PathVariable(value = "buildingId") String buildingId) {
        ParkingAreaFindByBuildingId.Input input = new ParkingAreaFindByBuildingId.Input();
        input.setBuildingId(buildingId);
        return modelConverter.mapAllByIterator(parkingAreaFindByBuildingId.execute(input), ParkingAreaFindByBuildingIdResponse.class);
    }
}
