package com.arteni.mag.service.payment;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.Models.PaymentResponse;

public class CardPaymentService {

    public PaymentResponse processPayment(CardPayment cardPayment) {
        PaymentResponse paymentResponse = new PaymentResponse(1L, "SUCCESS", "details: all good");
        return paymentResponse;
    }

}
