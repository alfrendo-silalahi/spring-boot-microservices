package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
    name = "Customer",
    description = "Schema to hold Customer and Account information."
)
public class CustomerDTO {
    
    @Schema(
        description = "Name of the customer.",
        example = "Alfrendo Silalahi"
    )
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
        description = "Email of the customer.",
        example = "alfrendosilalahi@email.com"
    )
    @NotEmpty(message = "Email cannot be a null or empty")
    @Email(message = "Email should be a valid format")
    private String email;

    @Schema(
        description = "Mobile number of the customer.",
        example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
        description = "Account detail of Customer"
    )
    private AccountsDTO account;

}
