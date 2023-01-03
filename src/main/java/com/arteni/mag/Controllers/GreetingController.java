package com.arteni.mag.Controllers;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingController {

//    private final CardPaymentRepositoryDAO cardPaymentRepositoryDAO;
//
//    public GreetingController(CardPaymentRepositoryDAO cardPaymentRepositoryDAO) {
//        this.cardPaymentRepositoryDAO = cardPaymentRepositoryDAO;
//    }

    @RequestMapping("/ping")
    public @ResponseBody String respondToPing() {
        return "pong";
    }

//    @GetMapping("/test/payment/{id}")
//    CardPayment findById(@PathVariable Long id) {
//        return cardPaymentRepositoryDAO.findById(id);
//    }

}