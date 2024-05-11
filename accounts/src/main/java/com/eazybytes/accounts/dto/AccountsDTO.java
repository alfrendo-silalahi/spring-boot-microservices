package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
    name = "Accounts",
    description = "Schema to hold Account information."
)
public class AccountsDTO {

    @NotEmpty(message = "Account number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    @Schema(
        description = "Account number of Alfrendo Silalahi Bank"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType cannot be a null or empty")
    @Schema(
        description = "Account type of Alfrendo Silalahi Bank",
        example = "Savings"
    )
    private String accountType;

    @NotNull(message = "BranchAddress cannot be a null or empty")
    @Schema(
        description = "Alfrendo Silalahi branch address"
    )
    private String branchAddress;

}