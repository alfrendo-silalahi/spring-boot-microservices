package com.eazybytes.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_200;
import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_201;
import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_417_DELETE;
import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_417_UPDATE;
import static com.eazybytes.accounts.constant.AccountsConstant.MESSAGE_500;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_200;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_201;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_417;
import static com.eazybytes.accounts.constant.AccountsConstant.STATUS_500;

import com.eazybytes.accounts.dto.CustomerDTO;
import com.eazybytes.accounts.dto.ErrorResponseDTO;
import com.eazybytes.accounts.dto.ResponseDTO;
import com.eazybytes.accounts.service.AccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
    name = "CRUD REST APIs for Accounts in Alfrendo Silalahi Bank",
    description = "CRUD REST APIs in Alfrendo Silalahi Bank to CREATE, UPDATE, FETCH and DELETE account detail."
)
@RestController
@RequestMapping(path = "/api/accounts", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @Operation(
        summary = "Create Account REST API",
        description = "REST API to create new Customer & Account inside Alfrendo Silalahi Bank."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "HTTP Status INTERNAL SERVER ERROR",
            content = @Content(
                schema = @Schema(
                    implementation = ErrorResponseDTO.class
                )
            )
        )
    })
    @PostMapping
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {
        accountsService.createNewAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(STATUS_201, MESSAGE_201));
    }

    @Operation(
        summary = "Get Account detail REST API",
        description = "REST API to get Customer & Account detail based on a mobile number."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "HTTP Status INTERNAL SERVER ERROR",
            content = @Content(
                schema = @Schema(
                    implementation = ErrorResponseDTO.class
                )
            )
        )
    })
    @GetMapping
    public ResponseEntity<CustomerDTO> getAccountDetail(@RequestParam("mobile_number") String mobileNumber) {
        CustomerDTO customerDTO = accountsService.getAccountDetail(mobileNumber);
        return ResponseEntity.ok(customerDTO);
    }

    @Operation(
        summary = "Update Account REST API",
        description = "REST API to update Customer & Account detail based on a mobile number."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
        ),
        @ApiResponse(
            responseCode = "417",
            description = "HTTP Status EXPECTATION FAILED"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "HTTP Status INTERNAL SERVER ERROR",
            content = @Content(
                schema = @Schema(
                    implementation = ErrorResponseDTO.class
                )
            )
        )
    })
    @PutMapping
    public ResponseEntity<ResponseDTO> updateAccountDetail(@Valid @RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountsService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(STATUS_200, MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(STATUS_417, MESSAGE_417_UPDATE));
        }
    }

    @Operation(
        summary = "Delete Account REST API",
        description = "REST API to delete Customer & Account detail based on a mobile number."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
        ),
        @ApiResponse(
            responseCode = "417",
            description = "HTTP Status EXPECTATION FAILED"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "HTTP Status INTERNAL SERVER ERROR",
            content = @Content(
                schema = @Schema(
                    implementation = ErrorResponseDTO.class
                )
            )
        )
    })
    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteAccount(@RequestParam("mobile_number") String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(STATUS_200, MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(STATUS_417, MESSAGE_417_DELETE));
        }
    }

}
