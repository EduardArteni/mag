package com.arteni.mag.service.payment;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.Models.PaymentResponse;
import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {

    @Autowired
    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO;


    public PaymentResponse processPayment(CardPayment cardPayment) {
        PaymentResponse paymentResponse = null;

        if(cardPayment.getTransactionAmount() < 1000){
            cardPaymentRepositoryDAO.createCardPayment(cardPayment);
            paymentResponse = new PaymentResponse(cardPayment, PaymentResponse.SUCCESS, "details: all good");
        } else {
            paymentResponse = new PaymentResponse(cardPayment, PaymentResponse.FAILED, "transaction failed");
        }
        return paymentResponse;
    }

}
