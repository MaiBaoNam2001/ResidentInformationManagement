package com.citynow.residentinformationmanagement.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApartmentFindByFloorIdResponse implements Serializable {
    private String id;
    private String name;
    private String floor_id;
}
