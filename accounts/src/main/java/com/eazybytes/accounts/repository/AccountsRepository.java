package com.eazybytes.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eazybytes.accounts.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    
    Optional<Accounts> findByCustomerId(Long customerId);

    void deleteByCustomerId(Long customerId);

}   
