package com.service.cardstatementservice.service;

import com.service.cardstatementservice.entity.Card;
import com.service.cardstatementservice.entity.Statement;
import java.util.List;
import java.util.Map;


public interface CardStatementService {
    Map<Card, List<Statement>> getAllCardStatements();

    List<Statement> getListOfStatements(Long cardId);
}
