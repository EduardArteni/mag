package com.arteni.mag.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CARD_PAYMENT")
public class CardPayment {

    private @Id
    @GeneratedValue(strategy= GenerationType.AUTO) Long id;
    private String cardType;// VISA, MASTER_CARD, AMERICAN_EXPRESS

    private String cardNumber;//4111111111

    private double transactionAmount;

    private String cardHolderName;

    private Date expDate;

    private String CV2;

    public CardPayment() {
    }

    public CardPayment(Long id, String cardType, String cardNumber) {
        this.id = id;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }
    public CardPayment(Long id, String cardType, String cardNumber, double transactionAmount,
                       String cardHolderName, Date expDate, String CV2) {
        this.id = id;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.transactionAmount = transactionAmount;
        this.cardHolderName = cardHolderName;
        this.expDate = expDate;
        this.CV2 = CV2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getCV2() {
        return CV2;
    }

    public void setCV2(String CV2) {
        this.CV2 = CV2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPayment that)) return false;
        return getId().equals(that.getId()) && getCardType().equals(that.getCardType()) && getCardNumber().equals(that.getCardNumber()) && getCardHolderName().equals(that.getCardHolderName()) && getExpDate().equals(that.getExpDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardType(), getCardNumber(), getCardHolderName(), getExpDate());
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
