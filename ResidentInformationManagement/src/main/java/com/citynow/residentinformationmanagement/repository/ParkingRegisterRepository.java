package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.ParkingRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRegisterRepository extends JpaRepository<ParkingRegister, String> {

}
