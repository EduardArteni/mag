package com.arteni.mag.dao;

import com.arteni.mag.Models.CardPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class CardPaymentRepositoryDAO {

    private final String SQL_INSERT_CARD_PAYMENT = "INSERT INTO public.\"CARD_PAYMENT\"(\"card_Type\", \"card_Number\", \"transaction_Amount\", \"card_Holder_Name\", \"exp_Date\", \"CV2\") VALUES (?, ?, ?, ?, ?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CardPayment findById(long id) {
        CardPayment cardPayment = (CardPayment) jdbcTemplate.queryForObject("SELECT * FROM public.\"CARD_PAYMENT\" WHERE id = ?",
                new CardPaymentRowMapper(), id);
        return cardPayment;
    }

    public CardPayment createCardPayment(CardPayment cardPayment) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(SQL_INSERT_CARD_PAYMENT, new String[]{"id"});
                        ps.setString(1, cardPayment.getCardType());
                        ps.setString(2, cardPayment.getCardNumber());
                        ps.setDouble(3, cardPayment.getTransactionAmount());
                        ps.setString(4, cardPayment.getCardHolderName());
                        ps.setDate(5, new Date(cardPayment.getExpDate().getTime()));
                        ps.setString(6, cardPayment.getCV2());
                        return ps;
                    }
                },
                keyHolder);

        cardPayment.setId(keyHolder.getKey().longValue());

        return cardPayment;
    }

}