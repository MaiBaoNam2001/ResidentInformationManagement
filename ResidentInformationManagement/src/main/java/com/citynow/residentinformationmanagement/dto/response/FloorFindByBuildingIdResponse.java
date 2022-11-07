package com.citynow.residentinformationmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class FloorFindByBuildingIdResponse implements Serializable {
    private String id;
    @JsonProperty("name")
    private int number;
    private String building_id;
}
