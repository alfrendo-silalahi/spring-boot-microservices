package com.eazybytes.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_200;
import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_201;
import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_500;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_200;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_201;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_500;

import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.AccountsService;

@RestController
@RequestMapping(path = "/api/accounts", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
        accountsService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(STATUS_201, MESSAGE_201));
    }

    @GetMapping
    public ResponseEntity<CustomerDTO> getAccountDetail(@RequestParam("mobile_number") String mobileNumber) {
        CustomerDTO customerDTO = accountsService.getAccountDetail(mobileNumber);
        return ResponseEntity.ok(customerDTO);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateAccountDetail(@RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountsService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(STATUS_200, MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(STATUS_500, MESSAGE_500));
        }
    }

}
