package com.rakbank.paymentgatewayservice.service;

import com.rakbank.paymentgatewayservice.data.dto.TransactionRequest;

public interface PaymentCallbackService {

    void process(TransactionRequest request,String transactionReference) throws InterruptedException;
}
