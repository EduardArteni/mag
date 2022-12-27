package com.arteni.mag.Controllers;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CardPaymentController {

    @Autowired
    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO;

    @GetMapping("/api/CardPayments/{id}")
    CardPayment findById(@PathVariable Long id) {
        return cardPaymentRepositoryDAO.findById(id);
    }


}
