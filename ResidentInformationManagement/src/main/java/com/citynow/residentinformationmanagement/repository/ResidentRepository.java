package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, String> {
}
