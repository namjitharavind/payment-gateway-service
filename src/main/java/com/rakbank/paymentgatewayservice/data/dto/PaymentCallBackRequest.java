package com.rakbank.paymentgatewayservice.data.dto;



import com.rakbank.paymentgatewayservice.data.enums.TransactionStatus;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaymentCallBackRequest {
    private String transactionId;
    private String transactionReferenceId;
    private TransactionStatus transactionStatus;
}
