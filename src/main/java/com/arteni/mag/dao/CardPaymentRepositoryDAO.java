package com.arteni.mag.dao;

import com.arteni.mag.Models.CardPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class CardPaymentRepositoryDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public CardPayment findById(long id) {
        CardPayment cardPayment = (CardPayment) jdbcTemplate.queryForObject("SELECT * FROM public.\"CARD_PAYMENT\" WHERE id = ?",
                new CardPaymentRowMapper(), id);
        return cardPayment;
    }

}