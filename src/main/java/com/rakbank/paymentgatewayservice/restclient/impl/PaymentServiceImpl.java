package com.rakbank.paymentgatewayservice.restclient.impl;


import com.rakbank.paymentgatewayservice.data.dto.PaymentCallBackRequest;
import com.rakbank.paymentgatewayservice.restclient.PaymentService;
import com.rakbank.paymentgatewayservice.restclient.properties.PaymentServiceProperties;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final String SERVICE_NAME = "payment-service";

    @Qualifier("payment-service-rest-client")
    private final RestClient restClient;

    private final PaymentServiceProperties properties;

    @Retry(name = SERVICE_NAME, fallbackMethod = "updateStatus")
    @Override
    public void updateStatus(PaymentCallBackRequest request) {
        log.info("Calling Payment Service : {}", properties.getPaymentStatusUpdateCallbackApi());

        ResponseEntity<Void> response = restClient.post()
                .uri(properties.getPaymentStatusUpdateCallbackApi())
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .body(request)
                .retrieve()
                .toBodilessEntity();

        log.info("Payment Service Api call result: {}", response);

    }

    private void updateStatus(PaymentCallBackRequest request, Exception e) {
        log.error("Pushed to a dead letter queue for later call back");
    }
}
