package com.service.cardstatementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    Long cardId;
    String cardHolderName;
    String panNumber;
    Date validDate;
}
