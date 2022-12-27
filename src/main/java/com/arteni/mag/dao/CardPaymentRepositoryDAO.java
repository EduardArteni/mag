package com.arteni.mag.dao;

import com.arteni.mag.Models.CardPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CardPaymentRepositoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CardPayment findById(long id) {
        CardPayment cardPayment = (CardPayment) jdbcTemplate.queryForObject("SELECT * FROM public.\"CARD_PAYMENT\" WHERE id = ?",
                new CardPaymentRowMapper(), id);
        return cardPayment;
    }

}