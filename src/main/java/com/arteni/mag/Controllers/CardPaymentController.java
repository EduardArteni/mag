package com.arteni.mag.Controllers;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.Models.PaymentResponse;
import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import com.arteni.mag.service.payment.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(value = "/api/v2/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardPaymentController {

    @Autowired
    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO;
    @Autowired
    private CardPaymentService cardPaymentService;

    @GetMapping("/{id}")
    public CardPayment getCardPaymentById(@PathVariable Long id) {
        return cardPaymentRepositoryDAO.findById(id);
    }

    @PostMapping
    public PaymentResponse createCardPayment(@RequestBody CardPayment customerFromReq) {
        return cardPaymentService.processPayment(customerFromReq);
    }
}
