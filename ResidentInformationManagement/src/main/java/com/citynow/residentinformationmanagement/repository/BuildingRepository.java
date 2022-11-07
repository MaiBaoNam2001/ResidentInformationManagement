package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, String> {
    @Query("SELECT b FROM Building b WHERE b.project.id = :projectId")
    List<Building> findByProjectId(@Param("projectId") String projectId);
}
