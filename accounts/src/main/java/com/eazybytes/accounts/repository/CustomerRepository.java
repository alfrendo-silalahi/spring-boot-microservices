package com.eazybytes.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eazybytes.accounts.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
