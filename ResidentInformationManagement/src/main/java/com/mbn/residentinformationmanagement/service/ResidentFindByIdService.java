package com.mbn.residentinformationmanagement.service;

import com.mbn.residentinformationmanagement.entity.Resident;
import com.mbn.residentinformationmanagement.service.template.IService;

import java.util.Optional;

public interface ResidentFindByIdService extends IService<String, Optional<Resident>> {
}
