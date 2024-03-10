package com.eazybytes.accounts.service;

import org.springframework.stereotype.Service;

import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {

    }

}
