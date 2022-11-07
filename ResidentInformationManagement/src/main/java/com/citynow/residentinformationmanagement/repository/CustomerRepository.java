package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
