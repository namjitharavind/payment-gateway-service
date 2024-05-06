package com.rakbank.paymentgatewayservice.data.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
public class TransactionRequest {

    private String transactionId;
    private String cardNumber;
    private String cardExpiry;
    private String cardCvv;
    private String cardHolderName;
    private String type;
}
