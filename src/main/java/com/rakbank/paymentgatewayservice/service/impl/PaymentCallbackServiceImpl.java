package com.rakbank.paymentgatewayservice.service.impl;

import com.rakbank.paymentgatewayservice.data.dto.PaymentCallBackRequest;
import com.rakbank.paymentgatewayservice.data.dto.TransactionRequest;
import com.rakbank.paymentgatewayservice.data.enums.TransactionStatus;
import com.rakbank.paymentgatewayservice.restclient.PaymentService;
import com.rakbank.paymentgatewayservice.service.PaymentCallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class PaymentCallbackServiceImpl implements PaymentCallbackService {

    private final PaymentService paymentService;

    @Async
    @Override
    public void process(TransactionRequest transactionRequest,String transactionReference) throws InterruptedException {
        try {
            Thread.sleep(10000); // Sleep for 10 seconds
            PaymentCallBackRequest paymentCallBackRequest=new PaymentCallBackRequest();
            paymentCallBackRequest.setTransactionId(transactionRequest.getTransactionId());
            paymentCallBackRequest.setTransactionReferenceId(transactionReference);
            paymentCallBackRequest.setTransactionStatus(TransactionStatus.CAPTURED);
            paymentService.updateStatus(paymentCallBackRequest);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
