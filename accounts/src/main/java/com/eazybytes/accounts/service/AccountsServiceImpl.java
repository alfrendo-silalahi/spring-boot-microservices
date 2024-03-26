package com.eazybytes.accounts.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eazybytes.accounts.constant.AccountsConstant;
import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exception.CustomerAlreadyExistsException;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public void createAccount(CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number " + customerDTO.getMobileNumber());
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        
        // Temporary
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        
        Customer newCustomer = customerRepository.save(customer);
        
        accountsRepository.save(createAccounts(newCustomer));
    }   

    private Accounts createAccounts(Customer customer) {
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        System.out.println("Random number " + randomAccNumber);
        newAccounts.setAccountNumber(randomAccNumber);
        newAccounts.setAccountType(AccountsConstant.SAVINGS);
        newAccounts.setBranchAddress(AccountsConstant.ADDRESS);

        // Temporary
        newAccounts.setCreatedAt(LocalDateTime.now());
        newAccounts.setCreatedBy("Anonymous");

        return newAccounts;
    }

}
