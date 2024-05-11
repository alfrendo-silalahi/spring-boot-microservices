package com.eazybytes.accounts.documentation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "Accounts Microservice REST API Documentation",
        description = "Alfrendo Silalahi Bank Accounts microservice REST API documentation.",
        version = "v1",
        contact = @Contact(
            name = "Alfrendo Stenley Silalahi",
            email = "alfrendos72@gmail.com",
            url = "alfrendosilalahi.vercel.app"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "alfrendosilalahi.vercel.app"
        )
    ),
    externalDocs = @ExternalDocumentation(
        description = "Alfrendo Silalahi Bank Accounts microservice REST API documentation.",
        url = "alfrendosilalahi.vercel.app"
    )
)
public class OpenAPIConfig {
    
}
