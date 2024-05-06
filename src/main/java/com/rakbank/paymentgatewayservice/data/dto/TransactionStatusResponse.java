package com.rakbank.paymentgatewayservice.data.dto;


import com.rakbank.paymentgatewayservice.data.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;


@AllArgsConstructor
@Getter
@Setter
public class TransactionStatusResponse {

    private TransactionStatus transactionStatus;
    private ZonedDateTime transactionDate;
}
