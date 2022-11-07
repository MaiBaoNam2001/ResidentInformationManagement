package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingAreaRepository extends JpaRepository<ParkingArea, String> {
    @Query("SELECT p FROM ParkingArea p WHERE p.building.id = :buildingId")
    List<ParkingArea> findByBuildingId(@Param("buildingId") String buildingId);
}
