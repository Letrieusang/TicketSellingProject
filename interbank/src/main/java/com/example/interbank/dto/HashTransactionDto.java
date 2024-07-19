package com.example.interbank.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class HashTransactionDto {
    private String secretKey;
    private TransactionDto transactionDto;

    @Override
    public String toString() {
        return "HashTransactionDto{" +
                "secretKey=" + secretKey +
                ", transactionDto=" + transactionDto.toString() +
                '}';
    }
}
