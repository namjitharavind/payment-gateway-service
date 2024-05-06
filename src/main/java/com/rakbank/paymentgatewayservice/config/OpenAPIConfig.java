package com.rakbank.paymentgatewayservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Payment Gateway Service",
                description = "Payment Gateway Service will provide all API's required for dummy payment gateway which do callback",
                version="1.0",
                license = @License(
                        name = "Apache 2.0",
                        url="http://springdoc.org"
                ),
                termsOfService = "http://swagger.io/terms/"
        ),
        servers = {
                @Server(
                        description = "Local",
                        url="http://localhost:9084"
                )
        }
)
@Configuration
public class OpenAPIConfig {

}
