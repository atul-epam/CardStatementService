package com.service.cardstatementservice.controller;

import com.service.cardstatementservice.entity.Card;
import com.service.cardstatementservice.entity.Statement;
import com.service.cardstatementservice.service.CardStatementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CardStatementController {

    final CardStatementService cardStatementService;

    CardStatementController(CardStatementService cardStatementService) {
        this.cardStatementService = cardStatementService;
    }

    @GetMapping("statement-by-card")
    public Map<Card, List<Statement>> getAllCardStatements() {

        return cardStatementService.getAllCardStatements();
    }

    @GetMapping("statement-by-card/{cardId}")
    public ResponseEntity<Object> getAllCardStatements(@PathVariable Long cardId) {
        List<Statement> statementList = cardStatementService.getListOfStatements(cardId);
        if(statementList == null || statementList.isEmpty()) {
            return new ResponseEntity<>("Statement not found for Card id " + cardId, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(statementList);
    }

}
