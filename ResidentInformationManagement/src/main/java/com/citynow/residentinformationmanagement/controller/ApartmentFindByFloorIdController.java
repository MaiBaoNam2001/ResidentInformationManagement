package com.citynow.residentinformationmanagement.controller;

import com.citynow.residentinformationmanagement.common.mapper.ModelConverter;
import com.citynow.residentinformationmanagement.dto.response.ApartmentFindByFloorIdResponse;
import com.citynow.residentinformationmanagement.service.ApartmentFindByFloorId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApartmentFindByFloorIdController {
    private final ApartmentFindByFloorId apartmentFindByFloorId;
    private final ModelConverter modelConverter;

    @GetMapping("/apartments/{floorId}")
    public List<ApartmentFindByFloorIdResponse> findApartmentsByFloorId(@PathVariable(value = "floorId") String floorId) {
        ApartmentFindByFloorId.Input input = new ApartmentFindByFloorId.Input();
        input.setFloorId(floorId);
        return modelConverter.mapAllByIterator(apartmentFindByFloorId.execute(input), ApartmentFindByFloorIdResponse.class);
    }
}
