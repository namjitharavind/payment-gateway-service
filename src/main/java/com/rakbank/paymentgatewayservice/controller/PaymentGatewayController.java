package com.rakbank.paymentgatewayservice.controller;


import com.rakbank.paymentgatewayservice.core.data.ErrorResponse;
import com.rakbank.paymentgatewayservice.data.dto.TransactionRequest;
import com.rakbank.paymentgatewayservice.data.dto.TransactionResponse;
import com.rakbank.paymentgatewayservice.data.dto.TransactionStatusResponse;
import com.rakbank.paymentgatewayservice.data.enums.TransactionStatus;
import com.rakbank.paymentgatewayservice.service.PaymentCallbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment-gateway")
@Tag(name = "Payment Gateway")
public class PaymentGatewayController {

    private final PaymentCallbackService paymentCallbackService;

    @Operation(
            description = "Create a payment transaction",
            tags = {"Payment Gateway"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
            })
    }
    )
    @PostMapping
    public ResponseEntity<TransactionResponse> payment(@RequestBody TransactionRequest request) throws InterruptedException {
        String transactionReference=UUID.randomUUID().toString();
            paymentCallbackService.process(request,transactionReference);
        return ResponseEntity.accepted().body(new TransactionResponse(transactionReference));
    }

    @Operation(
            description = "Get Transaction by Id",
            tags = {"Payment Gateway"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Transaction not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Unexpected error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @GetMapping(path = "/{id}")
    public TransactionStatusResponse getTransactionStatusById(@PathVariable String transactionId) {
        return new TransactionStatusResponse(TransactionStatus.CAPTURED, ZonedDateTime.now());
    }

}
