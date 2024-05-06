package com.rakbank.paymentgatewayservice.restclient;


import com.rakbank.paymentgatewayservice.data.dto.PaymentCallBackRequest;

public interface PaymentService {
    void updateStatus(PaymentCallBackRequest request);

}
