package com.arteni.mag.Controllers;

import com.arteni.mag.Models.CardPayment;
import com.arteni.mag.dao.CardPaymentRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping(value = "/api/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardPaymentController {

    @Autowired
    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO;

    @GetMapping("/{id}")
    ModelAndView findById(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cardPayment", cardPaymentRepositoryDAO.findById(id) );

        return modelAndView;
    }


    @PostMapping
    public CardPayment createCardPayment(@RequestBody CardPayment customerFromReq) {
        return cardPaymentRepositoryDAO.createCardPayment(customerFromReq);
    }

}
