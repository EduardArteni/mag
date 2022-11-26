package com.arteni.mag.Models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class CardPayment {
    private String cardType;// VISA

    private String cardNumber;//411111

    private BigDecimal transactionAmount;

    private String cardHolderName;

    private Date expDate;

    private String CV2;

    public CardPayment() {
    }

    public CardPayment(String cardType, String cardNumber, BigDecimal transactionAmount, String cardHolderName, Date expDate, String CV2) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.transactionAmount = transactionAmount;
        this.cardHolderName = cardHolderName;
        this.expDate = expDate;
        this.CV2 = CV2;
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

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
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
        return getCardType().equals(that.getCardType()) && getCardNumber().equals(that.getCardNumber()) && getTransactionAmount().equals(that.getTransactionAmount()) && getCardHolderName().equals(that.getCardHolderName()) && getExpDate().equals(that.getExpDate()) && getCV2().equals(that.getCV2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardType(), getCardNumber(), getTransactionAmount(), getCardHolderName(), getExpDate(), getCV2());
    }
}
