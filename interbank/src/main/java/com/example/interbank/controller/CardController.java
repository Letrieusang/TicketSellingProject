package com.example.interbank.controller;

import com.example.interbank.dto.*;
import com.example.interbank.model.Card;
import com.example.interbank.service.CardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/card")
@RestController
@CrossOrigin(origins = "http://localhost:6868")
public class CardController {
    private final CardService cardService;

    @GetMapping("get-balance/{cardCode}")
    public ResponseEntity<GetBalanceResDto> getBalance(@PathVariable String cardCode) {
        Card card = cardService.getCardByCardCode(cardCode).orElse(null);
        if (card != null) return ResponseEntity.ok(GetBalanceResDto.builder()
                        .errorCode(0)
                        .cardCode(cardCode)
                        .balance(card.getBalance())
                        .build());
        else return ResponseEntity.badRequest().body(GetBalanceResDto.builder()
                .errorCode(1)
                .cardCode(cardCode)
                .build());
    }

    @PutMapping("reset-balance")
    public ResponseEntity<ResetBalanceResDto> resetBalance(@RequestBody ResetBalanceReqDto resetBalanceReqDto) {
        Card card = cardService.resetBalance(resetBalanceReqDto);
        if (card != null) {
            ResetBalanceResDto resetBalanceResDto = ResetBalanceResDto.builder()
                    .errorCode(1)
                    .cardCode(card.getCardCode())
                    .owner(card.getCardHolderName())
                    .cvvCode(card.getCvvCode())
                    .dateExpired(card.getDateExpired())
                    .balance(card.getBalance())
                    .build();
            return ResponseEntity.ok(resetBalanceResDto);
        }
        return ResponseEntity.badRequest().body(ResetBalanceResDto
                .builder()
                .errorCode(0)
                .build());
        }

    @PutMapping("processTransaction")
    public ResponseEntity<ProcessTransactionResDto> processTransaction(@RequestBody ProcessTransactionReqDto processTransactionReqDto) {
        return ResponseEntity.ok(cardService.processTransaction(processTransactionReqDto));
    }

    @PostMapping("check-card")
    public Card checkCard(@RequestBody String cardCode) {
        return cardService.getCardByCardCode(cardCode).orElse(null);
    }

}

