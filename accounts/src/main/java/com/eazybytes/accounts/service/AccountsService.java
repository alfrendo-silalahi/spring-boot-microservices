package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface AccountsService {

    void createNewAccount(CustomerDTO customerDTO);

    CustomerDTO getAccountDetail(String mobileNumber);

    boolean updateAccount(CustomerDTO customerDTO);

    boolean deleteAccount(String mobileNumber);

}
