package com.example.interbank.dto;

import lombok.Getter;

@Getter
public class ProcessTransactionReqDto {
    private TransactionDto transaction;
    private String appCode;
    private String hashCode;
}
