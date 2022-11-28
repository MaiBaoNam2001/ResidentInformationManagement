package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.ParkingRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRegisterRepository extends JpaRepository<ParkingRegister, String> {

  @Query("SELECT COUNT(pr) > 0 FROM ParkingRegister  pr WHERE pr.licensePlate = :licensePlate")
  boolean existsByLicensePlate(@Param("licensePlate") String licensePlate);
}
