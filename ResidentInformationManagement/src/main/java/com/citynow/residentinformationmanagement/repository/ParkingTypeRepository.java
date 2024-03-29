package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.ParkingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingTypeRepository extends JpaRepository<ParkingType, Long> {

}
