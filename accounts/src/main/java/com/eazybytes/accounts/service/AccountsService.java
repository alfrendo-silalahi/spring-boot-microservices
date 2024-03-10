package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface AccountsService {

    /**
     * 
     * @param customerDTO
     */
    void createAccount(CustomerDTO customerDTO);

}
