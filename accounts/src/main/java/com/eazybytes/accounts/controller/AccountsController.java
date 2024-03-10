package com.eazybytes.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import static com.eazybytes.accounts.constant.AccountsConstant.*;

@RestController
@RequestMapping(path = "/api/accounts", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AccountsController {

    @PostMapping
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(STATUS_201, MESSAGE_201));
    }

}
