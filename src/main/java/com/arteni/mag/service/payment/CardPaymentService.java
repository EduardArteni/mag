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

        if(cardPayment.getTransactionAmount() > 1000){
            return new PaymentResponse(cardPayment, PaymentResponse.FAILED, "transaction failed, exceeded the 1000 limit ");
        }
        if(!"VISA".equalsIgnoreCase(cardPayment.getCardType())){
            return new PaymentResponse(cardPayment, PaymentResponse.FAILED, "transaction failed: We support only VISA type cards");
        }
        if(cardPayment.getCardNumber().length() !=16){
            return new PaymentResponse(cardPayment, PaymentResponse.FAILED, "transaction failed: Invalid Card length");
        }
        cardPaymentRepositoryDAO.createCardPayment(cardPayment);
        return new PaymentResponse(cardPayment, PaymentResponse.SUCCESS, "details: all good");
    }

}
