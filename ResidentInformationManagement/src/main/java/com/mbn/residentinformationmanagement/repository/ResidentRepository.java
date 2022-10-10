package com.mbn.residentinformationmanagement.repository;

import com.mbn.residentinformationmanagement.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResidentRepository extends JpaRepository<Resident, String> {
}
