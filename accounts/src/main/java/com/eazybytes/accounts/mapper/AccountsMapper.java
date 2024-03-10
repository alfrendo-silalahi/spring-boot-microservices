package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountsDTO;
import com.eazybytes.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO) {
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        return accountsDTO;
    }

    public static Accounts mapToAccounts(AccountsDTO accountsDTO, Accounts accounts) {
        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setAccountNumber(accountsDTO.getAccountNumber());
        return accounts;
    }

}
