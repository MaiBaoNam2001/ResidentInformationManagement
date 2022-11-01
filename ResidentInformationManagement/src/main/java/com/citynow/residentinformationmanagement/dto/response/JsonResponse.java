package com.citynow.residentinformationmanagement.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResponse implements Serializable {
    private final String status;
    private final Object result;
}
