package com.rakbank.paymentgatewayservice.data.enums;


public enum TransactionStatus {
    NOT_YET_STARTED,
    ACCEPTED,
    AUTHORIZED,
    CAPTURED,
    DECLINED,
    CANCELLED,
    PENDING,
    REFUNDED,
    ERROR;
}
