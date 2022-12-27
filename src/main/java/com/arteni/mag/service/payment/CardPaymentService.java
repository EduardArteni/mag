package com.arteni.mag.service.payment;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.Models.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {

    public PaymentResponse processPayment(CardPayment cardPayment) {
        PaymentResponse paymentResponse = null;

        if(cardPayment.getTransactionAmount() < 100){
            paymentResponse = new PaymentResponse(1L, PaymentResponse.SUCCESS, "details: all good");
        } else {
            paymentResponse = new PaymentResponse(1L, PaymentResponse.FAILED, "transaction failed");
        }
        return paymentResponse;
    }

}
