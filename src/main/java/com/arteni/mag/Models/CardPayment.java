package com.arteni.mag.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CARD_PAYMENT")
public class CardPayment {

    private @Id
    @GeneratedValue Long id;
    private String cardType;// VISA, MASTER_CARD, AMERICAN_EXPRESS

    private String cardNumber;//4111111111

    private BigDecimal transactionAmount;

    private String cardHolderName;

    private Date expDate;

    private String CV2;

    public CardPayment() {
    }

    public CardPayment(Long id, String cardType, String cardNumber, BigDecimal transactionAmount, String cardHolderName, Date expDate, String CV2) {
        this.id = id;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.transactionAmount = transactionAmount;
        this.cardHolderName = cardHolderName;
        this.expDate = expDate;
        this.CV2 = CV2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPayment that)) return false;
        return id.equals(that.id) && cardType.equals(that.cardType) && cardNumber.equals(that.cardNumber) && transactionAmount.equals(that.transactionAmount) && cardHolderName.equals(that.cardHolderName) && expDate.equals(that.expDate) && CV2.equals(that.CV2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardType, cardNumber, transactionAmount, cardHolderName, expDate, CV2);
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "id=" + id +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expDate=" + expDate +
                ", CV2='" + CV2 + '\'' +
                '}';
    }
}
