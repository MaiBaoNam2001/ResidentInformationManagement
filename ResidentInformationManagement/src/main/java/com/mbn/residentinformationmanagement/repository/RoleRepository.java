package com.mbn.residentinformationmanagement.repository;

import com.mbn.residentinformationmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.id not in (1, 2)")
    public List<Role> findAll();

    Role findByName(String name);
}
