package com.arteni.mag.Models;

public class PaymentResponse {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    private CardPayment payment;
    private String status;
    private String detail;

    public PaymentResponse() {
    }

    public PaymentResponse(CardPayment payment, String status, String detail) {
        this.payment = payment;
        this.status = status;
        this.detail = detail;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public CardPayment getPayment() {
        return payment;
    }

    public void setPayment(CardPayment payment) {
        this.payment = payment;
    }
}
