package com.arteni.mag.Controllers;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(value = "/api/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardPaymentController {

    @Autowired
    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO;

    @GetMapping("/{id}")
    CardPayment findById(@PathVariable Long id) {
        return cardPaymentRepositoryDAO.findById(id);
    }


    @RequestMapping("/ping")
    public @ResponseBody String greeting() {
        return "pong";
    }
}
