package com.service.cardstatementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statement {
    Long statementId;
    Long cardId;
    double amount;
    Date statementDate;
}
