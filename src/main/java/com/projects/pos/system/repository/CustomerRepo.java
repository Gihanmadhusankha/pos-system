package com.projects.pos.system.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projects.pos.system.entity.Customer;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    List<Customer> findAllByActiveStatus(Boolean condition);

    @Modifying
    @Query(value = "update customer_table set customer_name=?1, customer_nic=?2 where id=?3", nativeQuery = true)
    void updateCustomersUsingQuery(String name, String nic, Long id);

    Optional<Customer> findByNicEquals(String nic);
    Optional<Customer> findByIdEquals(Long id);
}
