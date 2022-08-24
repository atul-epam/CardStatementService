package com.service.cardstatementservice.service;

import com.service.cardstatementservice.entity.Card;
import com.service.cardstatementservice.entity.Statement;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class CardStatementServiceImpl implements CardStatementService{

    final RestTemplate restTemplate;

    public CardStatementServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Map<Card, List<Statement>> getAllCardStatements() {
        Map<Card, List<Statement>> mapOfStatements = new LinkedHashMap<>();
        for (Card card : getListOfCards()) {
            mapOfStatements.put(card, getListOfStatements(card.getCardId()));
        }
        return mapOfStatements;
    }

    private List<Card> getListOfCards() {
        Card[] cards = restTemplate.getForObject("http://localhost:8080/cards/", Card[].class);
        assert cards != null;
        return Arrays.asList(cards);
    }

    public List<Statement> getListOfStatements(Long cardId) {
        try {
            Statement[] statement = restTemplate.getForObject("http://localhost:8081/statements/" + cardId, Statement[].class);
            assert statement != null;
            return Arrays.asList(statement);
        }
        catch(RestClientException e) {
            return null;
        }
    }
}
