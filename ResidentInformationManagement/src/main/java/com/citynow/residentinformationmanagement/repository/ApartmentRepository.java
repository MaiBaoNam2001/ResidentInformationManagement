package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, String> {
    @Query("SELECT a FROM Apartment  a WHERE a.floor.id = :floorId")
    List<Apartment> findByFloorId(@Param("floorId") String floorId);
}
