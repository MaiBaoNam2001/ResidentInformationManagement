package com.mbn.residentinformationmanagement.repository;

import com.mbn.residentinformationmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
