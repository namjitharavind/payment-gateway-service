package com.rakbank.paymentgatewayservice.restclient.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "rest.api.payment.service")
public class PaymentServiceProperties {
    private String name;
    private String baseUrl;
    private String paymentStatusUpdateCallbackApi;
}
