package com.citynow.residentinformationmanagement.repository;

import com.citynow.residentinformationmanagement.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

  @Query("SELECT COUNT(c) > 0 FROM Customer c WHERE c.identityCard = :identityCard AND c.isDeleted = false")
  boolean existsByIdentityCard(@Param("identityCard") String identityCard);

  @Query("SELECT c FROM Customer c WHERE c.identityCard = :identityCard AND c.isDeleted = false")
  Optional<Customer> findByIdentityCard(@Param("identityCard") String identityCard);
}
