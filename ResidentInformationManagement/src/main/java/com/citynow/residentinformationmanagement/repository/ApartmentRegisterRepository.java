package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.ApartmentRegister;
import com.citynow.residentinformationmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRegisterRepository extends JpaRepository<ApartmentRegister, String> {
    @Query("SELECT ar FROM ApartmentRegister ar WHERE ar.apartment.id = :apartmentId ")
    List<ApartmentRegister> findByApartmentId(@Param("apartmentId") String apartmentId);
}
